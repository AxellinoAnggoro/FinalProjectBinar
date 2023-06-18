package com.example.finalproject.model.airports


import com.google.gson.annotations.SerializedName

data class AirportsResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)