package com.example.finalproject.model.airports


import com.google.gson.annotations.SerializedName

data class Airport(
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imgURL")
    val imgURL: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)