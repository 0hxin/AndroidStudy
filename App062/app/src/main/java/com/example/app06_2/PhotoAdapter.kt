package com.example.app06_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app06_2.databinding.ItemListBinding

class PhotoAdapter(val photoList:MutableList<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    inner class PhotoHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoHolder {
        return PhotoHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoHolder, position: Int) {
        holder.binding.txId.setText(photoList[position].id)
        holder.binding.txUrl.setText(photoList[position].url)
        holder.binding.txTitleId.setText(photoList[position].title)
        holder.binding.imageView.setImageResource(photoList[position].albumId)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

}