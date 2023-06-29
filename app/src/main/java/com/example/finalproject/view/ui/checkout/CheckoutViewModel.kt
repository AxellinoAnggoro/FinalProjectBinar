package com.example.finalproject.view.ui.checkout

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.passenger.post.Passengers
import com.example.finalproject.model.passenger.post.ResponsePassenger
import com.example.finalproject.model.profile.User
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
    val liveDataProfile: MutableLiveData<User> = MutableLiveData()

    fun updateProfile(token: String, name: String, email: String, phoneNumber: String) {
        api.updateUser("Bearer $token", name, email, phoneNumber).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    liveDataProfile.value = response.body()
                } else {
                    Log.e("Checkout VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Checkout VM", "Failure View Model")
            }

        })
    }

    val liveDataPassenger: MutableLiveData<Passengers> = MutableLiveData()

    fun addPassenger(
        token: String,
        name: String,
        bornDate: String,
        citizen: String,
        idNumber: String,
        country: String
    ) {
        api.postPassengers("Bearer $token", name, bornDate, citizen, idNumber, country)
            .enqueue(object : Callback<Passengers> {
                override fun onResponse(call: Call<Passengers>, response: Response<Passengers>) {
                    if (response.isSuccessful){
                        liveDataPassenger.value = response.body()
                    }else{
                        Log.e("Bio Penumpang VM", "Error View Model")
                    }
                }

                override fun onFailure(call: Call<Passengers>, t: Throwable) {
                    Log.e("Bio Penumpang VM", "Failure View Model")
                }

            })
    }
}