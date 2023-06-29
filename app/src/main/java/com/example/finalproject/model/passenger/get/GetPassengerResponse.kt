package com.example.finalproject.model.passenger.get


import com.google.gson.annotations.SerializedName

data class GetPassengerResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)