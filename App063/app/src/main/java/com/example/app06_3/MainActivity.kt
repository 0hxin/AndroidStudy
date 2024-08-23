package com.example.app06_3

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app06_3.databinding.ActivityMainBinding
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
            JsonClient.retrofit.doGetPhotos().enqueue(object:retrofit2.Callback<List<Photo>>{
                override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                    if (response.isSuccessful) {
                        Log.d("Photo onResponse :", "${response.body()}")
                        for (photo in response.body()!!) {
                            photoList.add(photo)
                        }
                        photoAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                    // error
                    Log.d("Photo onFailure :", t.localizedMessage)
                }

            })
        }

        // post
        binding.btnPost.setOnClickListener {
            var postList = mutableListOf<Post>()
            val postAdapter = PostAdapter(postList)
            binding.recylerView.adapter = postAdapter

            JsonClient.retrofit.doGetPosts().enqueue(object:retrofit2.Callback<List<Post>>{
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful) {
                        Log.d("Post onResponse : ", "${response.body()}")
                        for (post in response.body()!!) {
                            postList.add(post)
                        }
                        postAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    // error
                    Log.d("Post onFailure : ", t.localizedMessage)
                }

            })
        }

        // comment
        binding.btnComment.setOnClickListener {
            var commentList = mutableListOf<Comment>()
            val commentAdapter = CommentAdapter(commentList)

            binding.recylerView.adapter = commentAdapter

            JsonClient.retrofit.doGetComments().enqueue(object:retrofit2.Callback<List<Comment>>{
                override fun onResponse(
                    call: Call<List<Comment>>,
                    response: Response<List<Comment>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("Comment onResponse : ", "${response.body()}")
                        for (comment in response.body()!!) {
                            commentList.add(comment)
                        }
                        commentAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                    Log.d("Comment onFailure : ", t.localizedMessage)
                }

            })
        }
    }
}