package com.example.app06_2

import retrofit2.Call
import retrofit2.http.GET

interface PhotoInterface {
    @GET("photos/")
    fun doGetPhotos():Call<List<Photo>>
}