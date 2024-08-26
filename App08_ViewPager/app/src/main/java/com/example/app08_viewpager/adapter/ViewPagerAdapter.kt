package com.example.app08_viewpager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app08_viewpager.databinding.ItemViewpagerBinding

// RecyclerView 이용
class ViewPagerAdapter(val list:MutableList<DataPage>)
    : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemViewpagerBinding)
        :RecyclerView.ViewHolder(binding.root){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dpage = list.get(position)
        holder.binding.tvTitle.text = dpage.title
        holder.binding.recLayout.setBackgroundColor(dpage.color)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}