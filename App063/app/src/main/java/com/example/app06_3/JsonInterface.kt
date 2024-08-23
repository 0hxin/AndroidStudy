package com.example.app06_3

import retrofit2.Call
import retrofit2.http.GET

interface JsonInterface {
    @GET("photos/")
    fun doGetPhotos(): Call<List<Photo>>

    @GET("posts/")
    fun doGetPosts(): Call<List<Post>>

    @GET("comments/")
    fun doGetComments(): Call<List<Comment>>
}