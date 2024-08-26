package com.example.app05.movieRecycler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app05.R
import com.example.app05.databinding.Activity4MovieBinding

class MainActivity4_movie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity4_movie)
        val binding = Activity4MovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val posterID = arrayOf<Int>(
            R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
        )
       var movieList = mutableListOf<MovieItem>()
        //1. 데이터 생성
        for(i in posterID.indices){  //위치값
           // Log.d("posterID i :" ,"${i}" )
          val  movie = MovieItem(posterID[i], "타이틀${i}")
           movieList.add(movie)   // movieList 에 10개 movie  추가
        }
        //2. 어댑터 생성
        val movieAdapter = MovieAdapter(movieList)
        //3. 리사이클러 뷰 에 어댑터 연결
        binding.recyclerView4.adapter = movieAdapter
        
        //4. 리사이클러 뷰 레이아웃
      //  binding.recyclerView4.layoutManager = LinearLayoutManager(this)
        binding.recyclerView4.layoutManager = GridLayoutManager(this,3)

    }
}