package com.example.finalproject.model.airline


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("airline")
    val airline: Airline
)