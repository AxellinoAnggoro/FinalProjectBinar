//package com.example.finalproject.view.ui.hasilpencarian
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.finalproject.model.flight.FlightsResponse
//import com.example.finalproject.network.ApiService
//import dagger.hilt.android.lifecycle.HiltViewModel
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import javax.inject.Inject
//
//@HiltViewModel
//class NonLoginHasilPencarianViewModel @Inject constructor(private val api: ApiService) : ViewModel() {
//    private val liveDataFlight: MutableLiveData<List<FlightsResponse>> = MutableLiveData()
////    val responseFlight : LiveData<FlightsResponse> = liveDataFlight
//
//    fun getFlights(){
//        api.getAllFlight().enqueue(object : Callback<List<FlightsResponse>>{
//            override fun onResponse(
//                call: Call<List<FlightsResponse>>,
//                response: Response<List<FlightsResponse>>
//            ) {
//                if (response.isSuccessful){
//                    liveDataFlight.value = response.body()
//                }else{
//                    Log.e("Hasil Pencarian VM", "Error View Model")
//                }
//            }
//
//            override fun onFailure(call: Call<List<FlightsResponse>>, t: Throwable) {
//                Log.e("Hasil Pencarian VM", "Error View Model")
//            }
//
//        })
//    }
//}