package com.example.finalproject.view.ui.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.profile.User
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val api : ApiService) : ViewModel() {
    val liveDataProfile : MutableLiveData<User> = MutableLiveData()

    fun updateProfile(token: String ,name: String, email : String, phoneNumber: String){
        api.updateUser("Bearer $token", name, email, phoneNumber).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    liveDataProfile.value = response.body()
                }else{
                    Log.e("Account VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Account VM", "Error View Model")
            }

        })
    }

    val getDataProfile : MutableLiveData<User> = MutableLiveData()
    fun getUser(token: String){
        api.getUserByToken("Bearer $token").enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    getDataProfile.value = response.body()
                }else{
                    Log.e("Get Account VM", "Error View Model $response")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Get Account VM Failure", "Error View Model")
            }

        })
    }
}