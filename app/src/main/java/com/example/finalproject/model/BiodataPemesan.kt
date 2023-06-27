package com.example.finalproject.model

import com.google.gson.annotations.SerializedName

data class BiodataPemesan(
    @SerializedName("fullName")
    val email: String,
    @SerializedName("telephone")
    val name: String,
    @SerializedName("email")
    val phoneNumber: String
)
