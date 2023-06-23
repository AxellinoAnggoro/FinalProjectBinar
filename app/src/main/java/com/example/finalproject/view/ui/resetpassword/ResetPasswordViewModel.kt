package com.example.finalproject.view.ui.resetpassword

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.reset.ResponseReset
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
    var postResetPass: MutableLiveData<ResponseReset> = MutableLiveData()

    fun updateDataPassword(email: String, password: String) {
        api.postNewPass(email, password).enqueue(object : Callback<ResponseReset> {
            override fun onResponse(call: Call<ResponseReset>, response: Response<ResponseReset>) {
                if (response.isSuccessful) {
                    postResetPass.value = response.body()
                } else {
                    Log.e("Reset Password VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<ResponseReset>, t: Throwable) {
                Log.e("Reset Password VM", "Error View Model")
            }

        })
    }
}