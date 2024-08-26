package com.example.app04_intent.recyclerMemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app04_intent.databinding.ItemMemoBinding
import java.text.SimpleDateFormat

class CustomAdapter:RecyclerView.Adapter<CustomAdapter.Holder>() {
    var listData = mutableListOf<Memo>()

    // 중첩 클래스
    class Holder(val binding: ItemMemoBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "클릭 메모 = ${binding.textTitle.text}", Toast.LENGTH_SHORT).show()
            }
            binding.root.setOnLongClickListener {
                Toast.makeText(binding.root.context, "클릭 메모 = ${binding.textTitle.text}", Toast.LENGTH_SHORT).show()
                true
            }
        }
        fun setMemo(memo: Memo) {
            binding.textNo.text = "${memo.no}"
            binding.textTitle.text = "${memo.title}"

            var sdf = SimpleDateFormat("yyyy/MM/dd")
            var formatDate = sdf.format(memo.timestamp)
            binding.textDate.text = formatDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
}