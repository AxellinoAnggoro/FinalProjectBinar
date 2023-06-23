package com.example.finalproject.model.register


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)