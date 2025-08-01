package com.example.mmvmproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmvmproject.data.network.RetrofitClient
import com.example.mmvmproject.data.repository.UserRepositoryImpl
import com.example.mmvmproject.domain.entity.UserEntity
import com.example.mmvmproject.domain.repository.UserRepository
import com.example.mmvmproject.domain.useCase.GetUserByIdUseCase
import com.example.mmvmproject.domain.useCase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    //Intancias
    private val api = RetrofitClient()
    private val repository = UserRepositoryImpl(api = api.createRetrofit())
    private val getUserUseCase = GetUserUseCase(repository = repository)
    private val getUserByIdUseCase = GetUserByIdUseCase(repository = repository)

    //Varaibles
    private val _users = MutableStateFlow<List<UserEntity>>(emptyList())
    val users: StateFlow<List<UserEntity>> = _users

    init {
        getUsersList()
    }

    //Funciones
    fun getUsersList(){
        viewModelScope.launch {
            _users.value = getUserUseCase()
        }
    }
}