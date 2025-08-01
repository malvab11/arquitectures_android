package com.example.mmvmproject.interactor

import com.example.mmvmproject.entity.User
import com.example.mmvmproject.network.services.ApiService

//Logica de Negocio como UseCase
class UserInteractor(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> {
        val response = apiService.getUsersList()
        return response.map { User(id = it.id, name = it.name, username = it.username) }
    }
}