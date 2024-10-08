package com.example.app05.recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app05.R
import com.example.app05.databinding.Activity2RecyclerBinding

//p345
class MainActivity2_recycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity2_recycler)
        val binding = Activity2RecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //데이터생성
        val data = mutableListOf<String>()
        for(i in 1..30){
            data.add("Item $i")
        }
        //어댑터
        binding.recyclerView.adapter = MyAdapter(data)
        // recyclerView 의 layout  설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //구분선 출력
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }
}