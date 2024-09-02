package com.example.app10_member

import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.app10_member.databinding.ItemMemberBinding
import retrofit2.Call
import retrofit2.Response

class MemberAdapter(): RecyclerView.Adapter<MemberAdapter.Holder>() {
    var memberList = mutableListOf<Member>()

    interface OnItemClickLister {
        fun onItemClick(pos: Int)
    }
    var onItemClickLister:OnItemClickLister? = null

    class Holder(val binding: ItemMemberBinding) :RecyclerView.ViewHolder(binding.root){}

    // 추가
    fun addItem(member: Member) {
        memberList.add(member)
        notifyDataSetChanged()
    }

    // 수정
    fun updateItem(pos:Int, member: Member) {
        Log.d("response adapter pos", pos.toString())
        Log.d("response adapter id", member.id.toString())
        memberList.set(pos, member)
        notifyDataSetChanged()
    }

    // 삭제
    fun removeItem(pos:Int) {
        memberList.removeAt(pos)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val member = memberList.get(position)
        holder.binding.txtName.text = member.name
        holder.binding.txtPhone.text = member.phone
        holder.binding.txtEmail.text = member.email

        // 수정
        holder.itemView.setOnClickListener {
            onItemClickLister?.onItemClick(holder.adapterPosition)
        }

        // 삭제
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(it.context).run {
                setTitle("정말 삭제할까요?")
                setPositiveButton("삭제", object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        MemberClient.retrofit.deleteById(member.id).enqueue(object:retrofit2.Callback<Void>{
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                removeItem(holder.adapterPosition)
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Log.d("response delete fail : ", t.toString())
                            }
                        })
                    }

                })
                setNegativeButton("닫기", null)
                show()
            }

            true
        }
    }
}