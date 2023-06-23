package com.example.finalproject.model.reset


import com.google.gson.annotations.SerializedName

data class ResponseReset(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)