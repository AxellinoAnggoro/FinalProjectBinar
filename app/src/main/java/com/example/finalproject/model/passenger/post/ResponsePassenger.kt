package com.example.finalproject.model.passenger.post


import com.google.gson.annotations.SerializedName

data class ResponsePassenger(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)