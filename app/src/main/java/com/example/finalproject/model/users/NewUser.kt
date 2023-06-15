package com.example.finalproject.model.users


import com.google.gson.annotations.SerializedName

data class NewUser(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)