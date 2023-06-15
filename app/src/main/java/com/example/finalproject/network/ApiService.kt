package com.example.finalproject.network

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.finalproject.model.login.LoginResponse
import com.example.finalproject.model.users.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("user/register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email :String,
        @Field("password") password:String,
        @Field("phoneNumber") phoneNumber:String,
    ) : Call<RegisterResponse>

    @FormUrlEncoded
    @POST("user/login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<LoginResponse>
}