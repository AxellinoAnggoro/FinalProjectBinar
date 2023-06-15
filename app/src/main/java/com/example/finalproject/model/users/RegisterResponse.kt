package com.example.finalproject.model.users


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class RegisterResponse(
    @field:SerializedName("data")
    val `data`: Data,
    @field:SerializedName("status")
    val status: String
)

data class DataRegister(
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