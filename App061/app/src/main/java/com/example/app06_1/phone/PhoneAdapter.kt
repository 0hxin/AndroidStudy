package com.example.app06_1.phone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app06_1.databinding.ItemPhoneBinding

class PhoneAdapter (val phoneList:MutableList<Phone>)
    : RecyclerView.Adapter<PhoneAdapter.PhoneHolder>() {
    // 인터페이스
    interface OnItemClickLister {
        fun onItemClick(pos:Int)
    }
    
    var onItemClickLister: OnItemClickLister? = null // 인터페이스 OnItemClickLister 자료형 변수 선언

    // 추가
    fun addItem(phone: Phone) {
        phoneList.add(phone)
        notifyDataSetChanged()
    }
    // 수정
    fun updateItem(phone: Phone, position: Int) {
        val p = phoneList[position]
        p.name = phone.name
        p.tel = phone.tel

        notifyDataSetChanged()
    }
    // 삭제
    fun deleteItem(position: Int) {
        phoneList.removeAt(position)
        notifyDataSetChanged()
    }

    inner class PhoneHolder(val binding: ItemPhoneBinding)
        : RecyclerView.ViewHolder(binding.root) {
        init{
            // 이벤트 발생 (리사이클러 뷰 클릭 시), 인터페이스 onItemClick 값 대입
            itemView.setOnClickListener {
                // OnItemClickLister 호출 (adapterPosition 값을 넘겨줌)
                onItemClickLister?.onItemClick(adapterPosition) // null 값일 수도 있어서 물음표 붙이기
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneHolder {
        return PhoneHolder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhoneHolder, position: Int) {
        holder.binding.name.setText(phoneList[position].name)
        holder.binding.tel.setText(phoneList[position].tel)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}