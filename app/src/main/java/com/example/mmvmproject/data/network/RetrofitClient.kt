package com.example.mmvmproject.data.network

import com.example.mmvmproject.data.services.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun createRetrofit() : ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}