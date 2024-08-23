package com.example.app06_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app06_3.databinding.PostListBinding

class PostAdapter(val postList:MutableList<Post>)
    : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    class PostHolder(val binding: PostListBinding)
        : RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(PostListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        var post = postList[position]

        holder.binding.postId.text = post.id.toString()
        holder.binding.postTitle.text = post.title
        holder.binding.postBody.text = post.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}