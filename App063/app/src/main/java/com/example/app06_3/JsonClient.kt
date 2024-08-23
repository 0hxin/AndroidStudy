package com.example.app06_3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JsonClient {
    val retrofit:JsonInterface = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JsonInterface::class.java)
}