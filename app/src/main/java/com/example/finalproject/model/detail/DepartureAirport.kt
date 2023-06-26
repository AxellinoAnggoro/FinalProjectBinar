package com.example.finalproject.model.detail


import com.google.gson.annotations.SerializedName

data class DepartureAirport(
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("imgURL")
    val imgURL: String
)