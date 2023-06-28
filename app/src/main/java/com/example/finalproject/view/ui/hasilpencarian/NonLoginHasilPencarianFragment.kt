package com.example.finalproject.view.ui.hasilpencarian

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNonLoginHasilPencarianBinding
import com.example.finalproject.model.ItemHasilPencarian
import com.example.finalproject.model.ItemJadwal
import com.example.finalproject.model.detail.DataDetail
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.view.ui.adapter.JadwalAdapter
import com.example.finalproject.view.ui.bottomsheet.BottomSheetAdapter
import com.example.finalproject.view.ui.detailpenerbangan.DetailPenerbanganFragment
import com.example.finalproject.view.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NonLoginHasilPencarianFragment : Fragment(), PencarianAdapter.OnItemClickListener {

    lateinit var binding : FragmentNonLoginHasilPencarianBinding
    private lateinit var flightSearchVm : NonLoginHasilPencarianViewModel
    private lateinit var flightAdapter : PencarianAdapter
    lateinit var homeVm : HomeViewModel
    lateinit var fromPref : SharedPreferences
    lateinit var toPref : SharedPreferences
    lateinit var passengerPref : SharedPreferences
    lateinit var classPref : SharedPreferences
    lateinit var departurePref: SharedPreferences
    lateinit var arrivalPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHasilPencarianBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeVm = ViewModelProvider(this)[HomeViewModel::class.java]

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


        binding.toolbarTitle.text = "$cityFrom < > $cityTo - $passenger Penumpang - $seatClass"
        binding.etDate.text = departure

        flightAdapter = PencarianAdapter(emptyList(),this)
        binding.rvHasilPencarian.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = flightAdapter
        }


        flightSearchVm = ViewModelProvider(this)[NonLoginHasilPencarianViewModel::class.java]
//        flightSearchVm.fetchTicket()
//        flightSearchVm.liveDataFlight.observe(viewLifecycleOwner) { dataFlightList ->
//            dataFlightList?.let { flight ->
//                flightAdapter.updateData(flight as List<DataFlight>)
//            }
//        }
        flightSearchVm.fetchTicketByQuery(cityFrom!!, cityTo!!)
        flightSearchVm.liveDataFlightQuery.observe(viewLifecycleOwner){
            it?.let { flight ->
                flightAdapter.updateData(flight as List<DataFlight>)
            }
        }

        binding.topAppBar.setNavigationOnClickListener{
            findNavController().navigate(R.id.action_nonLoginHasilPencarianFragment_to_homeFragment)
        }

    }
    override fun onItemClick(data: DataFlight) {
        val id = data.id
        val bundle = Bundle()
        bundle.putInt("id",id)
        Log.d("NonLogin Frag", "onclick")
        findNavController().navigate(R.id.action_nonLoginHasilPencarianFragment_to_detailPenerbanganFragment,bundle)
    }
}