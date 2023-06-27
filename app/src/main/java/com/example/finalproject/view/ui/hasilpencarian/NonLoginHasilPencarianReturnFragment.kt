package com.example.finalproject.view.ui.hasilpencarian

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
import com.example.finalproject.databinding.FragmentNonLoginHasilPencarianReturnBinding
import com.example.finalproject.model.flight.DataFlight

class NonLoginHasilPencarianReturnFragment : Fragment(), PencarianAdapter.OnItemClickListener {
    lateinit var binding : FragmentNonLoginHasilPencarianReturnBinding
    lateinit var flightSearchVm : NonLoginHasilPencarianViewModel
    private lateinit var flightAdapter : PencarianAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHasilPencarianReturnBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flightAdapter = PencarianAdapter(emptyList(),this)
        binding.rvDeparture.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = flightAdapter
        }


        flightSearchVm = ViewModelProvider(this)[NonLoginHasilPencarianViewModel::class.java]
        flightSearchVm.fetchTicket()
        flightSearchVm.liveDataFlight.observe(viewLifecycleOwner) { dataFlightList ->
            dataFlightList?.let { flight ->
                flightAdapter.updateData(flight as List<DataFlight>)
            }
        }

        binding.ivBackBeranda.setOnClickListener{
            findNavController().navigate(R.id.action_nonLoginHasilPencarianReturnFragment_to_homeFragment)
        }

    }

    override fun onItemClick(data: DataFlight) {
        val id = data.id
        val bundle = Bundle()
        bundle.putInt("id",id)
        Log.d("NonLogin Frag", "onclick")
//        findNavController().navigate(R.id.,bundle)
    }
}