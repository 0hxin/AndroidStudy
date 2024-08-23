package com.example.app06_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun resetInputBtn() {
            binding.inputId.setText(null)
            binding.inputMsg.setText(null)

            binding.updateBtn.isEnabled = false
            binding.deleteBtn.isEnabled = false
        }

        val friendList = mutableListOf<Friend>()
        for (i in 0..5){
            friendList.add(Friend(R.drawable.profile, "친구${i}","${i}번 친구"))
        }

        val friendAdapter = FriendAdapter(friendList)
        var position = 0

        friendAdapter.onItemClickLister = object:FriendAdapter.OnItemClickLister{
            override fun onItemClick(pos: Int) {
                position = pos

                binding.inputId.setText(friendList[pos].name)
                binding.inputMsg.setText(friendList[pos].msg)

                binding.updateBtn.isEnabled = true
                binding.deleteBtn.isEnabled = true
            }

        }

        binding.friendList.adapter = friendAdapter
        binding.friendList.layoutManager = LinearLayoutManager(this)

        // 추가
        binding.insertBtn.setOnClickListener {
            var name = binding.inputId.text.toString()
            var msg = binding.inputMsg.text.toString()

            name = name.takeIf { it.isNotEmpty() } ?: "입력 없음"
            msg = msg.takeIf { it.isNotEmpty() } ?: "코멘트 없음"

            friendList.add(Friend(name, msg))
            friendAdapter.notifyDataSetChanged()

            resetInputBtn()
        }

        // 수정
        binding.updateBtn.setOnClickListener {
            var name = binding.inputId.text.toString()
            var msg = binding.inputMsg.text.toString()

            name = name.takeIf { it.isNotEmpty() } ?: "입력 없음"
            msg = msg.takeIf { it.isNotEmpty() } ?: "코멘트 없음"

            val updateFriend = friendList.get(position)
            updateFriend.name = name
            updateFriend.msg = msg

            friendAdapter.notifyDataSetChanged()
            resetInputBtn()
        }

        // 삭제
        binding.deleteBtn.setOnClickListener {
            friendList.removeAt(position)
            friendAdapter.notifyDataSetChanged()
            resetInputBtn()
        }
    }
}