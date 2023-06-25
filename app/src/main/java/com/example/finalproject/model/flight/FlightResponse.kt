package com.example.finalproject.model.flight


import com.google.gson.annotations.SerializedName

data class FlightResponse(
    @SerializedName("data")
    val `data`: List<DataFlight>,
    @SerializedName("status")
    val status: String
)