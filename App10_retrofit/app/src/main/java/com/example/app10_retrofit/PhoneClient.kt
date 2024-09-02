package com.example.app10_retrofit

// retrofit : RESTful API 통신에 사용
// RESTful : HTTP 사용 리소스 요청, 조작 웹 서비스 아키텍처
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhoneClient {
    // 데이터를 Json 형식으로 변환
    val retrofit:PhoneInterface = Retrofit.Builder()
        .baseUrl("http://10.100.105.204:8899")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PhoneInterface::class.java)
}