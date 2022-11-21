package com.promiseek.StickChat.Add.Fragment.TenorGifs

import com.example.example.ApiResults
import com.example.example.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalled {

    @GET("featured")
    fun getFeatured(@Query("key") key:String,@Query("client_key") client_key:String,@Query("limit") limit:String, @Query("pos") pos:String?):Call<ApiResults> ;
}