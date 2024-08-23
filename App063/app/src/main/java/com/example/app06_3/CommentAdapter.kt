package com.example.app06_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app06_3.databinding.CommentListBinding

class CommentAdapter(val commentList:MutableList<Comment>)
    : RecyclerView.Adapter<CommentAdapter.CommentHolder>() {
    class CommentHolder(val binding: CommentListBinding)
        : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        return CommentHolder(CommentListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        var comment = commentList[position]

        holder.binding.commentId.text = comment.id.toString()
        holder.binding.commentName.text = comment.name
        holder.binding.commentEmail.text = comment.email
        holder.binding.commentBody.text = comment.body
    }
}