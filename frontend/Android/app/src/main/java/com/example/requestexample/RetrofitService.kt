package com.example.requestexample

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Field

data class  ResponseDTO(var result: String? = null)

interface RetrofitService {
    @FormUrlEncoded
    @POST("/")
    fun sendMessage(@Field("message") message: String): Call<ResponseDTO>
}