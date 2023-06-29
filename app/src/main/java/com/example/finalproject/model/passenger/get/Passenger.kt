package com.example.finalproject.model.passenger.get


import com.google.gson.annotations.SerializedName

data class Passenger(
    @SerializedName("booking_id")
    val bookingId: Int,
    @SerializedName("born_date")
    val bornDate: String,
    @SerializedName("citizen")
    val citizen: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("identity_number")
    val identityNumber: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("publisher_country")
    val publisherCountry: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("valid_until")
    val validUntil: String
)