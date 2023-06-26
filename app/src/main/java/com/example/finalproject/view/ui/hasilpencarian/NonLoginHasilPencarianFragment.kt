package com.example.finalproject.view.ui.hasilpencarian

import android.content.Intent
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonLoginHasilPencarianFragment : Fragment(), PencarianAdapter.OnItemClickListener {

    lateinit var binding : FragmentNonLoginHasilPencarianBinding
    lateinit var flightSearchVm : NonLoginHasilPencarianViewModel
    lateinit var flightAdapter : PencarianAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHasilPencarianBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flightAdapter = PencarianAdapter(emptyList(),this)
        binding.rvHasilPencarian.apply {
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