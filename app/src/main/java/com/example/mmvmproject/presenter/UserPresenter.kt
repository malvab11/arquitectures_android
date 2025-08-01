package com.example.mmvmproject.presenter

import com.example.mmvmproject.entity.User
import com.example.mmvmproject.interactor.UserInteractor

//La vista lo invoca al presenter
class UserPresenter(private val interactor: UserInteractor) {
    suspend fun loadUsers() : List<User>{
        return interactor.getUsers()
    }
}