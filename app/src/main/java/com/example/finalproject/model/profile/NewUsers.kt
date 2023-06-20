package com.example.finalproject.model.profile


import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class NewUsers(
    @field:SerializedName("createdAt")
    val createdAt: String,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("password")
    val password: String,
    @field:SerializedName("phoneNumber")
    val phoneNumber: String,
    @field:SerializedName("updatedAt")
    val updatedAt: String
)