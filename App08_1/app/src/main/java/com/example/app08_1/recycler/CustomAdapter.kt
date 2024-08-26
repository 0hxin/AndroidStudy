package com.example.app08_1.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app08_1.databinding.ItemViewpagerBinding

// RecyclerView 이용
class CustomAdapter()
    : RecyclerView.Adapter<CustomAdapter.CustomHolder>() {

    val list:List<String> = mutableListOf(
        "View Pager One",
        "View Pager Two",
        "View Pager Three",
        "View Pager Four"
    )
    class CustomHolder(val binding: ItemViewpagerBinding)
        : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        return CustomHolder(ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.binding.textView.text = list[position]
    }
}