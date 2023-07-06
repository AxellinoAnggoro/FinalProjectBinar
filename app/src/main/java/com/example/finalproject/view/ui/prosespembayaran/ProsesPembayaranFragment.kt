package com.example.finalproject.view.ui.prosespembayaran

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.Util.Utill
import com.example.finalproject.databinding.FragmentProsesPembayaranBinding

import com.example.finalproject.view.ui.bottomsheetpaymentsuccess.BottomSheetPaymentSuccessFragment
import com.example.finalproject.view.ui.detailpenerbangan.DetailPenerbanganViewModel
import com.example.finalproject.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ProsesPembayaranFragment : Fragment() {

    lateinit var binding: FragmentProsesPembayaranBinding
    private lateinit var viewModel: ProsesPembayaranViewModel
    private lateinit var detailVm: DetailPenerbanganViewModel
    lateinit var passengerPref: SharedPreferences
    lateinit var homePref: SharedPreferences
    private val homeVm: HomeViewModel by viewModels()
    lateinit var roundtripPref: SharedPreferences
    lateinit var classPref : SharedPreferences
    lateinit var pricePref : SharedPreferences
    lateinit var rtPricePref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProsesPembayaranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        homePref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val token = homePref.getString("token", "")
        passengerPref =
            requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
        roundtripPref = requireContext().getSharedPreferences("roundtrip", Context.MODE_PRIVATE)

        classPref = requireContext().getSharedPreferences("data_class", Context.MODE_PRIVATE)
        pricePref = requireContext().getSharedPreferences("price", Context.MODE_PRIVATE)
        rtPricePref = requireContext().getSharedPreferences("rtprice", Context.MODE_PRIVATE)


        val roundtripStatus = roundtripPref.getBoolean("roundtrip_status", false)
        Log.d("rincian", "status: $roundtripStatus")
        val idSingle = homeVm.getIdTicket()
        val idRound = homeVm.getIdDep()

        if (roundtripStatus) {
            detailVm.fetchTicketId(idRound!!)
        } else if (!roundtripStatus) {
            detailVm.fetchTicketId(idSingle!!)
        }
        detailVm.liveDataFlightId.observe(viewLifecycleOwner) { detail ->
            val totalPassenger = passengerPref.getString("passenger", "")?.toInt()
//            val roundtripStatus = roundtripPref.getString("roundtrip_status", "")
            val classSeat = classPref.getString("class","")
            val price = pricePref.getString("price", "")
            val rtPrice = rtPricePref.getString("rtprice","")

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

                    tvTypePassengersCount.text = "${totalPassenger} Passengers"

                    tvDeparture.text = detail.departureAirport.city
                    tvDepartureDua.text = detail.arrivalAirport.city
                    tvJam.text =  setDeparture
                    tvJamDua.text =  setArrival
                    typeClass.text = classSeat
                    noBookingCode.text = detail.flightCode
                    tvHarga.text =totalPriceFormatted


                    if (roundtripStatus) {
                        tvDeparture.text = detail.departureAirport.city
                        tvDepartureDua.text = detail.arrivalAirport.city
                        tvJam.text =  setDeparture
                        tvJamDua.text =  setArrival
                        typeClass.text = classSeat
                        noBookingCode.text = detail.flightCode
                        tvHarga.text =totalRoundtripFormatted
                    }
                }
            }

        }



        binding.apply {
            cvGopay.setOnClickListener {
                if (expandLayoutGopay.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(cvGopay, AutoTransition())
                    expandLayoutGopay.visibility = View.VISIBLE
                    constraintLay.setBackgroundColor(resources.getColor(R.color.darkblue05))
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                } else {
                    TransitionManager.beginDelayedTransition(cvGopay, AutoTransition())
                    expandLayoutGopay.visibility = View.GONE
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                    constraintLay.setBackgroundColor(resources.getColor(R.color.neutral04))
                }
            }

            cvCreditCard.setOnClickListener {
                if (expandLayoutCreditCard.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(cvCreditCard, AutoTransition())
                    expandLayoutCreditCard.visibility = View.VISIBLE
                    constraintLay2.setBackgroundColor(resources.getColor(R.color.darkblue05))
                    ivArrow2.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                } else {
                    TransitionManager.beginDelayedTransition(cvCreditCard, AutoTransition())
                    expandLayoutCreditCard.visibility = View.GONE
                    constraintLay2.setBackgroundColor(resources.getColor(R.color.neutral04))
                    ivArrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                }
            }

            btnBayarGopay.setOnClickListener {
                BottomSheetPaymentSuccessFragment().show(
                    requireActivity().supportFragmentManager,
                    BottomSheetPaymentSuccessFragment.bottomTag
                )
            }
            btnBayarCreditCard.setOnClickListener {
                BottomSheetPaymentSuccessFragment().show(
                    requireActivity().supportFragmentManager,
                    BottomSheetPaymentSuccessFragment.bottomTag
                )
            }

            topAppBar.setNavigationOnClickListener {
                findNavController().navigate(R.id.rincianPenerbanganFragment2)
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