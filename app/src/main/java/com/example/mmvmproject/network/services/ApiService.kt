package com.example.mmvmproject.network.services

import com.example.mmvmproject.entity.User
import com.example.mmvmproject.network.dto.UsersDTO
import retrofit2.http.GET

interface ApiService {
    @GET ("users")
    suspend fun getUsersList(): List<UsersDTO>
}