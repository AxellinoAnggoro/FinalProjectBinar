package com.example.finalproject.model.detail


import com.google.gson.annotations.SerializedName

data class FlightIdResponse(
    @SerializedName("data")
    val `data`: DataDetail,
    @SerializedName("status")
    val status: String
)