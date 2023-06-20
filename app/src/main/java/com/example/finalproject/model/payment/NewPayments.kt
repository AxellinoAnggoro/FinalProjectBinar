package com.example.finalproject.model.payment


import com.google.gson.annotations.SerializedName

data class NewPayments(
    @SerializedName("booking_id")
    val bookingId: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("payment_amount")
    val paymentAmount: Int,
    @SerializedName("payment_date")
    val paymentDate: String,
    @SerializedName("payment_method")
    val paymentMethod: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)