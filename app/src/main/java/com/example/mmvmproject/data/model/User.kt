package com.example.mmvmproject.data.model

data class User (
    val id : Int,
    val name : String,
    val username: String,
    val email: String,
    val address: Address,
    val phone : String,
    val website: String,
    val company: Company
)

