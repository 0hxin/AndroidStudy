package com.example.app05.memoRecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app05.R
import com.example.app05.databinding.Activity3MemoBinding

class MainActivity3_memo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding  = Activity3MemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  setContentView(R.layout.activity3_memo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1. 데이터 생성
        val data:MutableList<Memo> = loadData()
        //2.어댑터생성
        var adapter = CustomAdapter()
        adapter.listData = data      //어댑터에 1에 만든 data  를 연결
        //3 리사이클러뷰에 어댑터 연결
        binding.recyclerView.adapter = adapter
        //4. 리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    //loadData 함수
     fun loadData():MutableList<Memo> {
         val data:MutableList<Memo> = mutableListOf()
        for(i in 1..100){
            val title = "RecyclerTest ${i+1}"
            val date = System.currentTimeMillis()
            var memo = Memo(i, title, date)  // 100개 Memo 생성
            data.add(memo)  // MutableList 에 100개 Memo 저장
        }
        return data
     }
}