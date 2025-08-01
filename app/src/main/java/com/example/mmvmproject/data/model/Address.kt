package com.example.mmvmproject.data.model

data class Address(
    val street: String,
    val suit: String,
    val city: String,
    val zipcode: String,
    val geo: GeoLocalize,
)
