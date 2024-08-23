package com.example.app06

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app06.databinding.ItempPerson2Binding

class Person2Adapter(val personList:MutableList<Person2>) :
    RecyclerView.Adapter<Person2Adapter.personHolder>() {
    inner class personHolder(val binding:ItempPerson2Binding):RecyclerView.ViewHolder(binding.root) {
        init{
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context,
                    "$position", Toast.LENGTH_SHORT).show()
            }
            itemView.setOnLongClickListener {
                val position = adapterPosition
                personList.removeAt(position)
                notifyDataSetChanged()
                true
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personHolder {
        return personHolder(ItempPerson2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: personHolder, position: Int) {
        val person = personList.get(position)
        holder.binding.name.setText(person.name)
        holder.binding.tel.setText(person.tel)
    }
}