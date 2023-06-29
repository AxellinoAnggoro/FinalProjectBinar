package com.example.finalproject.model.passenger.get


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("passengers")
    val passengers: List<Passenger>
)