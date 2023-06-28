package com.example.finalproject.view.ui.detailpenerbangan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentDetailPenerbanganBinding
import com.example.finalproject.model.detail.DataDetail
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailPenerbanganFragment : Fragment() {
    lateinit var binding : FragmentDetailPenerbanganBinding
    lateinit var  detailVm: DetailPenerbanganViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_detailPenerbanganFragment_to_biodataPemesanFragment)
        }

        val id = arguments?.getInt("id")
        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        detailVm.fetchTicketId(id!!)
        detailVm.liveDataFlightId.observe(viewLifecycleOwner){ detail ->
            binding.apply {
                val departureTime = detail!!.departureTime
                val setDeparture = getHourFromDateTime(departureTime)
                val arrivalTime = detail.arrivalTime
                val setArrival = getHourFromDateTime(arrivalTime)

                jadwalJam.text = setDeparture
                jadwalJamPulang.text = setArrival
                setBandara.text = detail.departureAirport.airportName
                typePlane.text = detail.airline.airlineName
                codePlane.text = detail.flightCode
                jmlBaggage.text = detail.airline.baggage.toString()
                jmlCabin.text = detail.airline.cabinBaggage.toString()
                setBandaraTujuan.text = detail.arrivalAirport.airportName
                setHarga.text = detail.economyClassPrice.toString()
            }
        }

        binding.topAppBar.setNavigationOnClickListener{
            findNavController().navigate(R.id.nonLoginHasilPencarianFragment)
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