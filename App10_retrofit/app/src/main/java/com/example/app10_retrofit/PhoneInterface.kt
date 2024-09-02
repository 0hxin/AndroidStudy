package com.example.app10_retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PhoneInterface {
    // 전체보기
    // 서버에서 Phone 객체를 가져옴
    // return 되는 것이 여러 개
    @GET("list")
    fun findAll(): Call<List<Phone>>

    // 추가
    // 서버에 새로운 Phone 객체를 추가
    // return, 즉 전달되는 것이 한 개
    // @Body : 추가할 Phone 객체를 JSON 형태로 변환
    @POST("insert")
    fun save(@Body phone: Phone):Call<Phone>

    // 수정
    // {id} : 수정할 Phone 객체 id = num
    // @Body : 수정된 Phone 객체를 JSON 형태로 변환
    @PUT("update/{id}")
    fun update(@Path("id") id:Long, @Body phone: Phone):Call<Phone>

    // 삭제
    // {id} : 삭제할 Phone 객체 id = num
    // 삭제는 return 값 없음
    @DELETE("delete/{id}")
    fun deleteById(@Path("id") id:Long):Call<Void>
}