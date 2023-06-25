package com.example.finalproject.view.ui.hasilpencarian

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.model.flight.FlightResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NonLoginHasilPencarianViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
    private val _flightData = MutableLiveData<List<DataFlight>?>()
    val flightData: LiveData<List<DataFlight>?> = _flightData

    fun getFlights(){
        api.getAllFlight().enqueue(object : Callback<List<DataFlight>>{
            override fun onResponse(
                call: Call<List<DataFlight>>,
                response: Response<List<DataFlight>>
            ) {
                if (response.isSuccessful){
                    val flights = response.body()
                    _flightData.value = flights
                }else{
                    Log.e("Hasil Pencarian VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<List<DataFlight>>, t: Throwable) {
                Log.e("Hasil Pencarian VM", "API call failed: ${t.message}")
            }

        })
    }
}