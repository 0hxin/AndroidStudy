package com.example.app04_intent.recycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app04_intent.R
import com.example.app04_intent.databinding.ActivityMainActivity2RecyclerBinding

class MainActivity2_recycler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainActivity2RecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main_activity2_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 데이터 생성
        val data = mutableListOf<String>()
        for (i in 1 .. 10) {
            data.add("Item $i")
        }
        // 어댑터
        binding.recyclerView.adapter = MyAdapter(data)
        // recyclerView layout 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 구분선 출력
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}