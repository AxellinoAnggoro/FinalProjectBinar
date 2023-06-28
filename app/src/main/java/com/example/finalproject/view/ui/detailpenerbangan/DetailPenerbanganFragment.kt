package com.example.finalproject.view.ui.detailpenerbangan

import android.content.Context
import android.content.SharedPreferences
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
import com.example.finalproject.Util.Utill
import com.example.finalproject.databinding.FragmentDetailPenerbanganBinding
import com.example.finalproject.model.detail.DataDetail
import com.example.finalproject.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailPenerbanganFragment : Fragment() {
    lateinit var binding : FragmentDetailPenerbanganBinding
    lateinit var  detailVm: DetailPenerbanganViewModel
    private val homeVm : HomeViewModel by viewModels()
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id")
        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)

        binding.btnMasuk.setOnClickListener {
            homeVm.saveIdTicket(id!!)
            val token = pref.getString("token", "")
            if (token!!.isNotEmpty()){
                if (findNavController().currentDestination!!.id == R.id.detailPenerbanganFragment){
                    findNavController().navigate(R.id.action_detailPenerbanganFragment_to_biodataPemesanFragment)

                }
            }else{
                val frag = findNavController().currentDestination?.id
                findNavController().popBackStack(frag!!, true)
                findNavController().navigate(R.id.bottomSheetLogin)
            }
        }

        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        detailVm.fetchTicketId(id!!)
        detailVm.liveDataFlightId.observe(viewLifecycleOwner){ detail ->
            binding.apply {
                val departureTime = detail!!.departureTime
                val setDeparture = getHourFromDateTime(departureTime)
                val arrivalTime = detail.arrivalTime
                val setArrival = getHourFromDateTime(arrivalTime)
                val getPrice = detail.economyClassPrice
                val price = Utill.getPriceIdFormat(getPrice)

                jadwalJam.text = setDeparture
                jadwalJamPulang.text = setArrival
                setBandara.text = detail.departureAirport.airportName
                typePlane.text = detail.airline.airlineName
                codePlane.text = detail.flightCode
                jmlBaggage.text = detail.airline.baggage.toString()
                jmlCabin.text = detail.airline.cabinBaggage.toString()
                setBandaraTujuan.text = detail.arrivalAirport.airportName
                setHarga.text = price
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