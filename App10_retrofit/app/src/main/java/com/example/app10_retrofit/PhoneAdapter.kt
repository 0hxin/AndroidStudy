package com.example.app10_retrofit

import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.app10_retrofit.databinding.CustomPhoneBinding
import com.example.app10_retrofit.databinding.ItemPhoneBinding
import retrofit2.Call
import retrofit2.Response

class PhoneAdapter(var phoneList:MutableList<Phone>)
    : RecyclerView.Adapter<PhoneAdapter.Holder>(){
    class Holder(val binding: ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root) {}
    // 추가
    fun addItem(phone: Phone) {
        phoneList.add(phone)
        notifyDataSetChanged()
    }
    // 수정
    fun updateItem(pos:Int, phone: Phone) {
        // phoneList 의 pos 위치에 있는 요소 phone 로 교체
        // phoneList 의 index 와 실제 DB 에 저장된 데이터 index 는 서로 다름
        phoneList.set(pos, phone)
        notifyDataSetChanged()
    }

    // 삭제
    fun removeItem(pos:Int) {
        // phoneList 의 pos 위치에 있는 요소 삭제
        phoneList.removeAt(pos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var phone = phoneList.get(position)
        holder.binding.txtName.text = phoneList[position].name
        holder.binding.txtPhone.text = phoneList[position].phone


        // 수정 클릭
        holder.itemView.setOnClickListener {
            // customDialog
            val dialogPhone = CustomPhoneBinding.inflate(LayoutInflater.from(it.context))
            AlertDialog.Builder(it.context).run {
                setTitle("수정")
                setMessage("수정하실 내용을 입력하세요.")
                // customDialog 부착
                setView(dialogPhone.root)
                // 사용자 클릭한 이름, 전화번호 EditText 세팅
                dialogPhone.edtName.setText(holder.binding.txtName.text)
                dialogPhone.edtPhone.setText(holder.binding.txtPhone.text)
                // 수정 버튼 클릭 이벤트
                setPositiveButton("수정", object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        // phoneList 의 position 순서에 있는 Phone 요소의 num 을 가져옴
                        val p = Phone(phone.num, dialogPhone.edtName.text.toString(), dialogPhone.edtPhone.text.toString())
                        PhoneClient.retrofit.update(phone.num, p).enqueue(object:retrofit2.Callback<Phone>{
                            override fun onResponse(call: Call<Phone>, response: Response<Phone>) {
                                // 성공
                                Log.d("response update", response.body().toString())
                                updateItem(holder.adapterPosition, p)
                            }

                            override fun onFailure(call: Call<Phone>, t: Throwable) {
                                // 실패
                                Log.d("response update fail", t.toString())
                            }
                        })
                    }
                })
                setNegativeButton("닫기", null)
                show()
            }
        }

        // 삭제 롱클릭
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(it.context).run {
                setTitle("정말 삭제할까요?")
                setPositiveButton("삭제", object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        PhoneClient.retrofit.deleteById(phone.num).enqueue(object:retrofit2.Callback<Void> {
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