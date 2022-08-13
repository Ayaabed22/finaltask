package com.example.application.Api

import com.example.application.DataModel
import com.example.application.Logindata
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiCalls {

    @GET("products")
    fun getproducts(

    ): Call<DataModel>

@GET("product")
fun getitemid(
    @Query ("id") id:Int
):Call<DataModel>

    @POST("login")
    fun login(
        @Body logindata: Logindata
    ): Call<ResponseBody>

}