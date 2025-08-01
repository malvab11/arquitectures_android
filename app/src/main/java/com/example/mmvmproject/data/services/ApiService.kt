package com.example.mmvmproject.data.services

import com.example.mmvmproject.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET ("users")
    suspend fun getUsers(): List<User>

    @GET ("users/{id}")
    suspend fun getUsersById(@Path("id") id: Int) : User

    @POST ("users")
    suspend fun createUser(@Body user: User): User
}