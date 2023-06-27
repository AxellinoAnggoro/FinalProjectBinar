package com.example.finalproject.model.profile


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("otp")
    val otp: Int,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("verified")
    val verified: Boolean
)