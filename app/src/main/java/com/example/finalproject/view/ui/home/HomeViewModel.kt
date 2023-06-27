package com.example.finalproject.view.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalproject.model.datastore.PassengersPreferences
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.model.flight.FlightResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.prefs.Preferences
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferences: PassengersPreferences,
    private val sharedPreferences: SharedPreferences,
    private val api: ApiService
) : ViewModel() {
    var liveDataFav : MutableLiveData<List<DataFlight?>?> = MutableLiveData()

    fun fetchFav(){
        api.getAllFlight().enqueue(object : Callback<FlightResponse>{
            override fun onResponse(
                call: Call<FlightResponse>,
                response: Response<FlightResponse>
            ) {
                if (response.isSuccessful) {
                    val ticketList = response.body()?.data
                    liveDataFav.value = ticketList
                } else {
                    Log.e("Fav List VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Log.e("Fav List VM", "API call failed: ${t.message}")
            }

        })
    }

    fun getPassenger(): LiveData<String> = preferences.getPassenger().asLiveData()

    fun getTanggalBerangkat(): LiveData<String> = preferences.getTanggalKeberangkatan().asLiveData()

    fun getTanggalPulang(): LiveData<String> = preferences.getTanggalPulang().asLiveData()

    fun getSeatClass(): LiveData<String> = preferences.getSeat().asLiveData()

    fun saveCheckSwitch(isCheck: Boolean){
        val editor = sharedPreferences.edit()
        editor.putBoolean("check",isCheck)
        editor.apply()
    }
}