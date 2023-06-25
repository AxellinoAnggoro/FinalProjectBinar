package com.example.finalproject.model.flight


import com.google.gson.annotations.SerializedName

data class ArrivalAirport(
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("imgURL")
    val imgURL: String
)