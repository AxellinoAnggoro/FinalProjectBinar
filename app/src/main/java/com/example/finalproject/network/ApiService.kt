package com.example.finalproject.network

import com.example.finalproject.model.airports.AirportsResponse
import com.example.finalproject.model.detail.FlightIdResponse
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.model.flight.FlightResponse
import com.example.finalproject.model.login.LoginResponse
import com.example.finalproject.model.otp.OtpResponse
import com.example.finalproject.model.profile.User
import com.example.finalproject.model.register.RegisterResponse
import com.example.finalproject.model.reset.ResponseReset
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("user/register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phoneNumber") phoneNumber: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("user/login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

//    @GET("flight")
//    fun getAllFlight(): Call<List<DataFlight>>

    @GET("flight")
    fun getAllFlight(): Call<FlightResponse>

    @GET("flight/{id}")
    fun getFlightById(
        @Path("id") userId: Int
    ): Call<FlightIdResponse>

    @GET("airports")
    fun getAllCity() : Call<AirportsResponse>

//    @FormUrlEncoded
//    @PUT("user/{id}")
//    fun updateUser(
//        @Header("Authorization") token: String,
//        @Path("id") userId: Int,
//        @Field("name") name: String,
//        @Field("email") email: String,
//        @Field("phoneNumber") phoneNumber: String
//    ): Call<NewUsers>

    @FormUrlEncoded
    @PUT("user/update")
    fun updateUser(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phoneNumber") phoneNumber: String
    ) : Call<User>

    @FormUrlEncoded
    @POST("user/verify")
    fun postOtp(
        @Field("email") email: String,
        @Field("otp") otp : Int
    ) : Call<OtpResponse>

    @FormUrlEncoded
    @PUT("user/reset-password")
    fun postNewPass(
        @Field("email") email: String,
        @Field("password") password : String
    ) : Call<ResponseReset>

}