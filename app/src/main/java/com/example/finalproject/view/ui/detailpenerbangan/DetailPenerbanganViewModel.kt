package com.example.finalproject.view.ui.detailpenerbangan

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.detail.DataDetail
import com.example.finalproject.model.detail.FlightIdResponse
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailPenerbanganViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
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
}