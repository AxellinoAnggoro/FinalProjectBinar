package com.example.finalproject.model.profile


import com.google.gson.annotations.SerializedName

data class UpdateProfileResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)