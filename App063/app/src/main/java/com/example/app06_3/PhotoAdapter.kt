package com.example.app06_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app06_3.databinding.PhotoListBinding

class PhotoAdapter(val photoList:MutableList<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    inner class PhotoHolder(val binding: PhotoListBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoHolder {
        return PhotoHolder(PhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoHolder, position: Int) {
        val photo = photoList[position]

        holder.binding.txId.text = photo.id.toString()
        holder.binding.txUrl.text = photo.url
        holder.binding.txTitle.text = photo.title
//        holder.binding.imageView.setImageResource(R.drawable.ic_launcher_background)

        Glide.with(holder.itemView)
            .load(photo.thumbnailUrl)
            .into(holder.binding.imageView)

        // 이미지 둥글게
        holder.binding.imageView.clipToOutline = true
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

}