package com.example.finalproject.model.payment


import com.google.gson.annotations.SerializedName

data class PaymentResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)