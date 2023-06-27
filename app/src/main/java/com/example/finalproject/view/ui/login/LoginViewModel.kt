package com.example.finalproject.view.ui.login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.login.LoginResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val api : ApiService) : ViewModel() {
    private var postLoginUsers : MutableLiveData<LoginResponse> = MutableLiveData()
    val responseLogin : LiveData<LoginResponse> = postLoginUsers

    fun authorizeLogin(email: String, password : String){
        api.postLogin(email, password).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    postLoginUsers.value = response.body()
                }else{
                    Log.e("Login VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Login VM Failure", "Error View Model")
            }

        })
    }
}