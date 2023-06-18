package com.example.finalproject.model.airline


import com.google.gson.annotations.SerializedName

data class AirlineResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)