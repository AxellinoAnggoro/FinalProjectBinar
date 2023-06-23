package com.example.finalproject.model.otp


import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)