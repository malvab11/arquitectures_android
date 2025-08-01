package com.example.mmvmproject.data.mappers

import com.example.mmvmproject.data.model.User
import com.example.mmvmproject.domain.entity.UserEntity

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        username = username
    )
}