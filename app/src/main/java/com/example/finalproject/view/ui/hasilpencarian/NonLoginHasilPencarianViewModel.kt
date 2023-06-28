package com.example.finalproject.view.ui.hasilpencarian

import android.content.SharedPreferences
import android.provider.ContactsContract.Data
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.detail.DataDetail
import com.example.finalproject.model.detail.FlightIdResponse
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.model.flight.FlightResponse
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NonLoginHasilPencarianViewModel @Inject constructor(private val api: ApiService, private val sharedPreferences: SharedPreferences) :
    ViewModel() {
    var liveDataFlight: MutableLiveData<List<DataFlight?>?> = MutableLiveData()
    fun fetchTicket() {
        api.getAllFlight().enqueue(object : Callback<FlightResponse> {
            override fun onResponse(
                call: Call<FlightResponse>,
                response: Response<FlightResponse>
            ) {
                if (response.isSuccessful) {
                    val ticketList = response.body()?.data
                    liveDataFlight.value = ticketList
                } else {
                    Log.e("Flight Search VM", "Error View Model")
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Log.e("Flight Search VM", "Error View Model")
            }

        })
    }

    var liveDataFlightQuery: MutableLiveData<List<DataFlight?>?> = MutableLiveData()
    fun fetchTicketByQuery(departureAirport: String, arrivalAirport: String) {
        api.getFlightByQuery(departureAirport, arrivalAirport)
            .enqueue(object : Callback<FlightResponse> {
                override fun onResponse(
                    call: Call<FlightResponse>,
                    response: Response<FlightResponse>
                ) {
                    if (response.isSuccessful) {
                        val ticketList = response.body()?.data
                        liveDataFlightQuery.value = ticketList
                    } else {
                        Log.e("Flight Search VM", "Error View Model")
                    }
                }

                override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                    Log.e("Flight Search VM", "Failure View Model")
                }

            })
    }

    var liveDataFlightId: MutableLiveData<DataDetail?> = MutableLiveData()
    fun fetchTicketId(id: Int) {
        api.getFlightById(id).enqueue(object : Callback<FlightIdResponse> {
            override fun onResponse(
                call: Call<FlightIdResponse>,
                response: Response<FlightIdResponse>
            ) {
                if (response.isSuccessful) {
                    val ticketDetail = response.body()?.data
                    liveDataFlightId.value = ticketDetail
                } else {
                    Log.e("Flight Detail VM", "Error View Model")
                }

            }

            override fun onFailure(call: Call<FlightIdResponse>, t: Throwable) {
                Log.e("Flight Detail VM", "Error View Model")
            }
        })
    }

    fun saveIdReturn(idReturn:Int){
        val editor = sharedPreferences.edit()
        editor.putInt("idReturn",idReturn)
        editor.apply()
    }
}