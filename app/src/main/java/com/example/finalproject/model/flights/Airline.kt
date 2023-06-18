package com.example.finalproject.model.flights


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("airline_name")
    val airlineName: String
)