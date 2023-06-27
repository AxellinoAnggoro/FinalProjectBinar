package com.example.finalproject.model.passenger


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("passengers")
    val passengers: Passengers
)