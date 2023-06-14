package com.example.finalproject.view.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding
import com.example.finalproject.view.ui.adapter.HomeAdapter
import com.example.finalproject.model.ItemDestinasi
import com.example.finalproject.view.ui.bottomsheet.BottomSheetFragment
import com.example.finalproject.view.ui.bottomsheetdatepicker.BottomSheetDatePickerFragment
import com.example.finalproject.view.ui.bottomsheetpenumpang.BottomSheetPenumpangFragment
import com.example.finalproject.view.ui.bottomsheetseatclass.BottomSheetSeatClassFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false)
        binding.rvDestinasi.layoutManager = layoutManager
        val itemDestinasi = listOf(
            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000")
        )
        homeAdapter = HomeAdapter(itemDestinasi)
        binding.rvDestinasi.adapter = homeAdapter

        binding.btnCariPenerbangan.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nonLoginHasilPencarianFragment)
        }

        binding.tvPilihFrom.setOnClickListener {
            BottomSheetFragment().show(requireActivity().supportFragmentManager,BottomSheetFragment.bottomTag)
        }
        binding.setPassengers.setOnClickListener {
            BottomSheetPenumpangFragment().show(requireActivity().supportFragmentManager,BottomSheetPenumpangFragment.bottomTag)
        }
        binding.setReturn.setOnClickListener {
            BottomSheetDatePickerFragment().show(requireActivity().supportFragmentManager,BottomSheetDatePickerFragment.bottomTag)
        }
        binding.setSeat.setOnClickListener {
            BottomSheetSeatClassFragment().show(requireActivity().supportFragmentManager,BottomSheetSeatClassFragment.bottomTag)
        }
    }




}