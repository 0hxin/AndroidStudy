package com.example.app05.personRecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app05.databinding.Item5PersonBinding

class PersonAdapter(val personList:MutableList<Person5>)
    :RecyclerView.Adapter<PersonAdapter.PersonHolder>(){
        //개별항목(item5_person)
   inner class PersonHolder(val binding:Item5PersonBinding)
               :RecyclerView.ViewHolder(binding.root){
      init{   // ==> onBindViewHolder 안의 주석부분과 같은 의미
          //클릭이벤트
          itemView.setOnClickListener {
              val position = adapterPosition
              Log.d("adapterPosition : ", "$position")
              Toast.makeText(itemView.context, "클릭 PersonHolder $position", Toast.LENGTH_SHORT).show()
          }
          //롱클릭이벤트
          itemView.setOnLongClickListener {
              val position = adapterPosition
              personList.removeAt(position)
              notifyDataSetChanged()
              true
         }
      }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(Item5PersonBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  personList.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
       val   person = personList.get(position)
        holder.binding.tvName.text  = person.name
        holder.binding.tvPhone.text = person.phone
 /***
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "클릭$position", Toast.LENGTH_SHORT).show()

        }
        //롱클릭 == >  삭제
        holder.itemView.setOnLongClickListener {
            personList.removeAt(position)   //personList.remove(person)
            notifyDataSetChanged()
            true
        }
 */
    }
}