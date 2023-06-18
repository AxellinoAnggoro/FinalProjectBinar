package com.example.finalproject.model.airline


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("airline_name")
    val airlineName: String,
    @SerializedName("baggage")
    val baggage: Int,
    @SerializedName("cabin_baggage")
    val cabinBaggage: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("updatedAt")
    val updatedAt: String
)