package com.example.finalproject.view.ui.detailpenerbangan.roundtrip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentDetailPulangBinding
import com.example.finalproject.view.ui.detailpenerbangan.DetailPenerbanganViewModel
import com.example.finalproject.view.ui.home.HomeViewModel
import java.text.SimpleDateFormat
import java.util.*

class DetailPulangFragment : Fragment() {

    lateinit var binding : FragmentDetailPulangBinding
    lateinit var detailVm : DetailPenerbanganViewModel
    lateinit var homeVm : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPulangBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")
        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        detailVm.fetchTicketId(id!!)
        detailVm.liveDataFlightId.observe(viewLifecycleOwner){ detail ->
            if (detail!=null) {
                binding.apply {
                    val departureTime = detail.departureTime
                    val setDeparture = getHourFromDateTime(departureTime)
                    val arrivalTime = detail.arrivalTime
                    val setArrival = getHourFromDateTime(arrivalTime)
                    tvJamBerangkat.text = setDeparture
                    tvBandara.text = detail.departureAirport.airportName
                    tvClassPesawat.text = detail.airline.airlineName
                    tvBookingCode.text = detail.flightCode
                    informasiSatu.text = "Baggage ${detail.airline.baggage}kg"
                    informasiDua.text = "Cabin Baggage ${detail.airline.cabinBaggage}kg"
                    tvJamDatang.text = setArrival
                    tvBandaraDatang.text = detail.arrivalAirport.airportName
//                setHarga.text = detail.economyClassPrice.toString()
                }
            }
        }
    }

    private fun getHourFromDateTime(dateTime: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val outputFormat = SimpleDateFormat("HH:mm", Locale.US)

        return try {
            val date = inputFormat.parse(dateTime)
            outputFormat.format(date!!)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

}