package com.example.finalproject.view.ui.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.profile.NewUsers
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val api : ApiService) : ViewModel() {
    val liveDataProfile : MutableLiveData<NewUsers> = MutableLiveData()

    fun updateProfile(token: String ,name: String, email : String, phoneNumber: String){
        api.updateUser("Bearer $token", 10, name, email, phoneNumber).enqueue(object : Callback<NewUsers>{
            override fun onResponse(call: Call<NewUsers>, response: Response<NewUsers>) {
                if (response.isSuccessful){
                    liveDataProfile.value = response.body()
                }else{
                    Log.e("Account VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<NewUsers>, t: Throwable) {
                Log.e("Account VM", "Error View Model")
            }

        })
    }
}