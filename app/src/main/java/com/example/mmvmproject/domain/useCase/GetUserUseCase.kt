package com.example.mmvmproject.domain.useCase

import com.example.mmvmproject.domain.entity.UserEntity
import com.example.mmvmproject.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke() : List<UserEntity> {
        return repository.getUser()
    }
}