package com.example.mmvmproject.data.repository

import android.util.Log
import com.example.mmvmproject.data.mappers.toEntity
import com.example.mmvmproject.data.services.ApiService
import com.example.mmvmproject.domain.entity.UserEntity
import com.example.mmvmproject.domain.repository.UserRepository

class UserRepositoryImpl(private val api: ApiService) : UserRepository {
    override suspend fun getUser(): List<UserEntity> {
        try {
            val response =  api.getUsers()
            return response.map { it.toEntity() }
        } catch(e: Exception) {
            Log.e("ErrorService", "Error en el servicio de GetUser: ${e.message}}")
            return emptyList()
        }
    }

    override suspend fun getUserById(id: Int): UserEntity? {
        try {
            val response = api.getUsersById(id = id)
            return response.toEntity()
        } catch(e: Exception) {
            Log.e("ErrorService", "Error en el servicio de getUserById: ${e.message}}")
            return null
        }
    }

}