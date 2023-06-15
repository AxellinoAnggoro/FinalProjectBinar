package com.example.finalproject.model.users


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("newUser")
    val newUser: NewUser
)