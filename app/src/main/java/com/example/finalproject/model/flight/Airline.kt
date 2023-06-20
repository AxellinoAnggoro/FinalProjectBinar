package com.example.finalproject.model.flight


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("airline_name")
    val airlineName: String
)