package com.example.finalproject.view.ui.bottomsheet

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.airports.Airport
import com.example.finalproject.model.airports.AirportsResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(private val api : ApiService) : ViewModel() {
    var liveDataFromTo : MutableLiveData<List<Airport?>?> = MutableLiveData()

    fun getCity(){
        api.getAllCity().enqueue(object : Callback<AirportsResponse>{
            override fun onResponse(
                call: Call<AirportsResponse>,
                response: Response<AirportsResponse>
            ) {
                if (response.isSuccessful) {
                    val airportList = response.body()?.data?.airport
                    liveDataFromTo.value = airportList
                } else {
                    Log.e("From To Dialog VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<AirportsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}