package com.example.application.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

     private  val retrofit: Retrofit? =null

    fun apiCalls(): ApiCalls
    {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://android-training.appssquare.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCalls::class.java)

        return retrofit

    }
}