package com.example.finalproject.model.profile


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("user")
    val user: User
)