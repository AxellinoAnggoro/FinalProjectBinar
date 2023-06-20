package com.example.finalproject.model.flight


import com.google.gson.annotations.SerializedName

data class FlightsResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)