package com.example.finalproject.model.airports


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("airport")
    val airport: List<Airport>
)