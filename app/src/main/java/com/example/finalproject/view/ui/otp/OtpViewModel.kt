package com.example.finalproject.view.ui.otp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.otp.OtpResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(private val api : ApiService) : ViewModel() {
    var postDataOtp : MutableLiveData<OtpResponse> = MutableLiveData()

    fun verifyOtp(email : String, otp : Int){
        api.postOtp(email, otp).enqueue(object : Callback<OtpResponse>{
            override fun onResponse(call: Call<OtpResponse>, response: Response<OtpResponse>) {
                if (response.isSuccessful){
                    postDataOtp.value = response.body()
                }else{
                    Log.e("OTP VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                Log.e("OTP VM", "Error View Model")
            }

        })
    }
}