package com.example.finalproject.model.register


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("newUserResponse")
    val newUserResponse: NewUserResponse
)