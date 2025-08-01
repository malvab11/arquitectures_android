package com.example.mmvmproject.domain.useCase

import com.example.mmvmproject.domain.entity.UserEntity
import com.example.mmvmproject.domain.repository.UserRepository

class GetUserByIdUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(id: Int) : UserEntity? {
        return repository.getUserById(id = id)
    }
}