package com.example.finalproject.model.detail


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("airline_name")
    val airlineName: String,
    @SerializedName("baggage")
    val baggage: Int,
    @SerializedName("cabin_baggage")
    val cabinBaggage: Int
)