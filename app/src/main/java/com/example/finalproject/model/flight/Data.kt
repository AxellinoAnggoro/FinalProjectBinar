package com.example.finalproject.model.flight


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("admin_id")
    val adminId: Int,
    @SerializedName("airline")
    val airline: Airline,
    @SerializedName("airline_id")
    val airlineId: Int,
    @SerializedName("arrival")
    val arrival: Int,
    @SerializedName("arrivalAirport")
    val arrivalAirport: Any,
    @SerializedName("arrival_time")
    val arrivalTime: String,
    @SerializedName("business_price")
    val businessPrice: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("departure")
    val departure: Int,
    @SerializedName("departureAirport")
    val departureAirport: Any,
    @SerializedName("departure_time")
    val departureTime: String,
    @SerializedName("economyClass_price")
    val economyClassPrice: Int,
    @SerializedName("firstClass_price")
    val firstClassPrice: Int,
    @SerializedName("flight_code")
    val flightCode: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("premiumEconomy_price")
    val premiumEconomyPrice: Int,
    @SerializedName("seat_id")
    val seatId: Int,
    @SerializedName("updatedAt")
    val updatedAt: String
)