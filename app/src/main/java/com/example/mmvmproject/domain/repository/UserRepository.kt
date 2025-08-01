package com.example.mmvmproject.domain.repository

import com.example.mmvmproject.domain.entity.UserEntity

interface UserRepository {
    suspend fun getUser() : List<UserEntity>
    suspend fun getUserById(id: Int) : UserEntity?
}