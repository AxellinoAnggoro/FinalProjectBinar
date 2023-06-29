package com.example.finalproject.view.ui.hasilpencarian

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.Util.Utill
import com.example.finalproject.databinding.FragmentNonLoginHasilPencarianReturnBinding
import com.example.finalproject.model.flight.DataFlight
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class NonLoginHasilPencarianReturnFragment : Fragment(), PencarianAdapter.OnItemClickListener {
    lateinit var binding: FragmentNonLoginHasilPencarianReturnBinding
    lateinit var flightSearchVm: NonLoginHasilPencarianViewModel
    private lateinit var flightAdapter: PencarianAdapter
    lateinit var fromPref: SharedPreferences
    lateinit var toPref: SharedPreferences
    lateinit var passengerPref: SharedPreferences
    lateinit var classPref: SharedPreferences
    lateinit var departurePref: SharedPreferences
    lateinit var arrivalPref: SharedPreferences
    lateinit var ticketAdapter: PencarianAdapter
    lateinit var depTimePref : SharedPreferences



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentNonLoginHasilPencarianReturnBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fromPref = requireContext().getSharedPreferences("data_asal", Context.MODE_PRIVATE)
        val cityFrom = fromPref.getString("city", "")

        toPref = requireContext().getSharedPreferences("data_tujuan", Context.MODE_PRIVATE)
        val cityTo = toPref.getString("city", "")

        passengerPref =
            requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
        val passenger = passengerPref.getString("passenger", "")

        classPref = requireContext().getSharedPreferences("data_class", Context.MODE_PRIVATE)
        val seatClass = classPref.getString("class", "")

        departurePref =
            requireContext().getSharedPreferences("data_berangkat", Context.MODE_PRIVATE)
        val departure = departurePref.getString("departure", "")

        arrivalPref = requireContext().getSharedPreferences("data_pulang", Context.MODE_PRIVATE)
        val arrival = arrivalPref.getString("arrival", "")

        depTimePref = requireContext().getSharedPreferences("data_berangkat", Context.MODE_PRIVATE)
        val depTime = depTimePref.getString("departure", "")

        val idDeparture = arguments?.getInt("idDep")


        binding.tvToolbar.text = "$cityFrom < > $cityTo - $passenger Penumpang - $seatClass"
        binding.etDate.text = departure
        binding.etDateReturn.text = arrival

        flightAdapter = PencarianAdapter(emptyList(), this)
        binding.rvDeparture.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = flightAdapter
        }


        flightSearchVm = ViewModelProvider(this)[NonLoginHasilPencarianViewModel::class.java]
        getDepartureTicket(idDeparture)

        flightSearchVm.fetchTicketByQuery(cityFrom!!, cityTo!!, depTime!!)
        flightSearchVm.liveDataFlightQuery.observe(viewLifecycleOwner) { dataFlightList ->
            dataFlightList?.let { flight ->
                flightAdapter.updateData(flight as List<DataFlight>)
            }
        }

            binding.ivBackBeranda.setOnClickListener {
                findNavController().navigate(R.id.action_nonLoginHasilPencarianReturnFragment_to_homeFragment)
            }

            binding.btnGanti.setOnClickListener {
                if (findNavController().currentDestination?.id == R.id.nonLoginHasilPencarianReturnFragment) {
//                val fragId = findNavController().currentDestination?.id
//                findNavController().popBackStack(fragId!!,true)
                    findNavController().navigate(R.id.action_nonLoginHasilPencarianReturnFragment_to_nonLoginHasilPencarianRoundFragment)
                }

            }

        }

        private fun getDepartureTicket(idDeparture: Int?) {
            flightSearchVm.fetchTicketId(idDeparture!!)
            flightSearchVm.liveDataFlightId.observe(viewLifecycleOwner) { it ->
                val departureTime = it!!.departureTime
                val setDeparture = getHourFromDateTime(departureTime)
                val arrivalTime = it.arrivalTime
                val setArrival = getHourFromDateTime(arrivalTime)

                binding.tvJamKeberangkatan.text = setDeparture
                binding.tvJamSampai.text = setArrival
                binding.tvKotaKeberangkatan.text = it.departureAirport.city
                binding.tvKotaSampai.text = it.arrivalAirport.city
                val getPrice = arguments?.getInt("pricePergi")
                val price = Utill.getPriceIdFormat(getPrice!!)
                binding.tvHarga.text = price
                binding.tvPesawat.text = it.airline.airlineName
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

        override fun onItemClick(data: DataFlight) {
            val idReturn = data.id
            val priceReturn = data.economyClassPrice
            val idDeparture2 = arguments?.getInt("idDep")
            val hargaPergi = arguments?.getInt("pricePergi")
            val bundle = Bundle()
            flightSearchVm.saveIdReturn(idReturn)
            bundle.putInt("idReturn", idReturn)
            bundle.putInt("idDeparture", idDeparture2!!)
            if (hargaPergi != null) {
                bundle.putInt("hargaPergi", hargaPergi)
            }
            bundle.putInt("hargaPulang", priceReturn)
            findNavController().navigate(R.id.action_nonLoginHasilPencarianReturnFragment_to_detailPenerbanganRoundtripFragment)

        }
    }