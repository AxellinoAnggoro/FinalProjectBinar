package com.example.finalproject.view.ui.register

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.register.RegisterResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
    private var postDataUsers : MutableLiveData<RegisterResponse> = MutableLiveData()
    val responseRegister: LiveData<RegisterResponse> = postDataUsers

    fun addDataRegis(name: String, email: String, password : String, phoneNumber : String){
        api.postRegister(name, email, password, phoneNumber).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    postDataUsers.value = response.body()
                }else{
                    Log.e("Register VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e("Register VM", "Error View Model")
            }

        })
    }

}