package com.example.app06_2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intentAction = intent.action
        Log.d(" ", "Intent Action: $intentAction")

        // layout
        binding.recylerView.layoutManager = LinearLayoutManager(this)

        // photo
        binding.btnPhoto.setOnClickListener {
            // 1. data
            var photoList = mutableListOf<Photo>()
            // 2. adapter
            val photoAdapter = PhotoAdapter(photoList)
            // 3. 연결
            binding.recylerView.adapter = photoAdapter
            PhotoClient.retrofit.doGetPhotos().enqueue(object:retrofit2.Callback<List<Photo>>{
                override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                    if (response.isSuccessful) {
                        Log.d("onResponse :", "${response.body()}")
                        for (photo in response.body()::) {
                            photoList.add(photo)
                        }
                    }
                }

                override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                    // error
                    Log.d("onFailure :", t.localizedMessage)
                }

            })
        }

        // post
        binding.btnPost.setOnClickListener {
            
        }
    }
}