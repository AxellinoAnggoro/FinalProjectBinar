package com.example.finalproject.view.ui.rincianpenerbangan

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
import com.example.finalproject.databinding.FragmentRincianPenerbanganBinding
import com.example.finalproject.view.ui.detailpenerbangan.DetailPenerbanganViewModel
import com.example.finalproject.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class RincianPenerbanganFragment : Fragment() {
    lateinit var binding: FragmentRincianPenerbanganBinding
    private lateinit var detailVm: DetailPenerbanganViewModel
    lateinit var passengerPref: SharedPreferences
    lateinit var homePref: SharedPreferences
    private val homeVm: HomeViewModel by viewModels()
    lateinit var roundtripPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRincianPenerbanganBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        val id = homeVm.getIdTicket()

//        val id = arguments?.getInt("id")
        homePref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val token = homePref.getString("token", "")
        passengerPref =
            requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
//        roundtripPref = requireContext().getSharedPreferences("roundtrip", Context.MODE_PRIVATE)


        binding.apply {
            btnLanjutPembayaran.setOnClickListener {
                findNavController().navigate(R.id.action_rincianPenerbanganFragment2_to_prosesPembayaranFragment)
            }
            topAppBar.setNavigationOnClickListener {
                findNavController().navigate(R.id.biodataPenumpangFragment)
            }
        }

        detailVm.fetchTicketId(id!!)
        detailVm.liveDataFlightId.observe(viewLifecycleOwner) { detail ->
            val totalPassenger = passengerPref.getString("passenger", "")?.toInt()
//            val roundtripStatus = roundtripPref.getBoolean("roundtrip_status", false)
//            Log.d("Checkout", "status roundtrip: $roundtripStatus")

            if (detail != null) {
                binding.apply {
                    val departureTime = detail!!.departureTime
                    val setDeparture = getHourFromDateTime(departureTime)
                    val arrivalTime = detail.arrivalTime
                    val setArrival = getHourFromDateTime(arrivalTime)
                    val getPrice = detail.economyClassPrice
                    val price = Utill.getPriceIdFormat(getPrice)
                    val totalPrice = totalPassenger?.times(getPrice)
                    val totalPriceFormatted = Utill.getPriceIdFormat(totalPrice!!)
                    val totalPriceRoundtrip = totalPrice.times(2)
                    val totalRoundtripFormatted = Utill.getPriceIdFormat(totalPriceRoundtrip)

                    tvJamBerangkat.text = setDeparture
                    tvJamDatang.text = setArrival
                    tvBandara.text = detail.departureAirport.airportName
                    tvBandaraDatang.text = detail.arrivalAirport.airportName
                    tvClassPesawat.text = detail.airline.airlineName
                    tvBookingCode.text = detail.flightCode
                    informasiSatu.text = "Baggage ${detail.airline.baggage}kg"
                    informasiDua.text = "Cabbin baggage ${detail.airline.cabinBaggage}kg"
                    setHargaTotal.text = price
                    tvDestinasi.text =
                        "${detail.departureAirport.city} -> ${detail.arrivalAirport.city}"
                    typePassengerAdult.text = "${totalPassenger} Passengers"
                    setHargaAdult.text = "${totalPassenger} x ${price}"
                    setHargaTotal.text = totalPriceFormatted

//                    if (roundtripStatus) {
//                        tvJamBerangkat.text = setDeparture
//                        tvJamDatang.text = setArrival
//                        tvBandara.text = detail.departureAirport.airportName
//                        tvBandaraDatang.text = detail.arrivalAirport.airportName
//                        tvClassPesawat.text = detail.airline.airlineName
//                        tvBookingCode.text = detail.flightCode
//                        informasiSatu.text = "Baggage ${detail.airline.baggage}kg"
//                        informasiDua.text = "Cabbin baggage ${detail.airline.cabinBaggage}kg"
//                        setHargaTotal.text = price
//                        tvDestinasi.text =
//                            "${detail.departureAirport.city} -> ${detail.arrivalAirport.city}"
//                        typePassengerAdult.text = "${totalPassenger} Passengers Roundtrip"
//                        setHargaAdult.text = "${totalPassenger} x ${price} x 2"
//                        setHargaTotal.text = totalRoundtripFormatted
//
//
//                    }
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