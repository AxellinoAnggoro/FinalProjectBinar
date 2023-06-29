package com.example.finalproject.view.ui.hasilpencarian

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNonLoginHasilPencarianRoundBinding
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.view.ui.home.HomeFragment
import com.example.finalproject.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonLoginHasilPencarianRoundFragment : Fragment(), PencarianAdapter.OnItemClickListener {
    lateinit var binding : FragmentNonLoginHasilPencarianRoundBinding
    lateinit var flightSearchVm : NonLoginHasilPencarianViewModel
    private lateinit var flightAdapter : PencarianAdapter
    lateinit var fromPref : SharedPreferences
    lateinit var toPref : SharedPreferences
    lateinit var passengerPref : SharedPreferences
    lateinit var classPref : SharedPreferences
    lateinit var departurePref: SharedPreferences
    lateinit var arrivalPref : SharedPreferences
    lateinit var homeVm : HomeViewModel
    lateinit var depTimePref : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHasilPencarianRoundBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeVm = ViewModelProvider(this).get(HomeViewModel::class.java)

        fromPref = requireContext().getSharedPreferences("data_asal", Context.MODE_PRIVATE)
        val cityFrom = fromPref.getString("city","")

        toPref = requireContext().getSharedPreferences("data_tujuan", Context.MODE_PRIVATE)
        val cityTo = toPref.getString("city","")

        passengerPref = requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
        val passenger = passengerPref.getString("passenger","")

        classPref = requireContext().getSharedPreferences("data_class", Context.MODE_PRIVATE)
        val seatClass = classPref.getString("class", "")

        departurePref = requireContext().getSharedPreferences("data_berangkat", Context.MODE_PRIVATE)
        val departure = departurePref.getString("departure","")

        arrivalPref = requireContext().getSharedPreferences("data_pulang", Context.MODE_PRIVATE)
        val arrival = arrivalPref.getString("arrival", "")

        depTimePref = requireContext().getSharedPreferences("data_berangkat", Context.MODE_PRIVATE)
        val depTime = depTimePref.getString("departure", "")


        binding.tvToolbar.text = "$cityFrom < > $cityTo - $passenger Penumpang - $seatClass"
        binding.etDate.text = departure
        binding.etDateReturn.text = arrival

        flightAdapter = PencarianAdapter(emptyList(),this)
        binding.rvDeparture.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = flightAdapter
        }


        flightSearchVm = ViewModelProvider(this)[NonLoginHasilPencarianViewModel::class.java]
        flightSearchVm.fetchTicketByQuery(cityFrom!!, cityTo!!, depTime!!)
        flightSearchVm.liveDataFlightQuery.observe(viewLifecycleOwner){
            it?.let { flight ->
                flightAdapter.updateData(flight as List<DataFlight>)
            }
        }
//        flightSearchVm.liveDataFlight.observe(viewLifecycleOwner) { dataFlightList ->
//            dataFlightList?.let { flight ->
//                flightAdapter.updateData(flight as List<DataFlight>)
//            }
//        }

    }

    override fun onItemClick(data: DataFlight) {
        val id = data.id
        val hargaPergi = data.economyClassPrice
        val bundle = Bundle()
        homeVm.saveIdDeparture(id)
        bundle.putInt("idDep", id)
        bundle.putInt("pricePergi", hargaPergi)
        findNavController().navigate(
            R.id.action_nonLoginHasilPencarianRoundFragment_to_nonLoginHasilPencarianReturnFragment,
            bundle
        )
    }
}