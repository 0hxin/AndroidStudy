package com.example.app06_1.friend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app06_1.databinding.ItemFriendBinding

class FriendAdapter(val friendList: MutableList<Friend>)
    : RecyclerView.Adapter<FriendAdapter.FriendHolder>() {

    interface OnItemClickLister {
        fun onItemClick(pos: Int)
    }
    var onItemClickLister: OnItemClickLister? = null

    inner class FriendHolder(val binding: ItemFriendBinding)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClickLister?.onItemClick(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
        return FriendHolder(ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FriendHolder, position: Int) {
        holder.binding.friendImg.setImageResource(friendList[position].resourceId)
        holder.binding.name.setText(friendList[position].name)
        holder.binding.msg.setText(friendList[position].msg)
    }

    override fun getItemCount(): Int {
        return friendList.size
    }
}