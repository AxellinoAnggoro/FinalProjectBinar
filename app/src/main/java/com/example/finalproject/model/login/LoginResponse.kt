package com.example.finalproject.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
     @field:SerializedName("data")
    val `data`: Data,
     @field:SerializedName("status")
    val status: String
)

data class LoginData(
     @field:SerializedName("email")
    val email: String,
     @field:SerializedName("token")
    val token: String,
     @field:SerializedName("username")
    val username: String
)