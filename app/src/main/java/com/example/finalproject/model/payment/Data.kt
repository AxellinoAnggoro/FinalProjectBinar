package com.example.finalproject.model.payment


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("newPayments")
    val newPayments: NewPayments
)