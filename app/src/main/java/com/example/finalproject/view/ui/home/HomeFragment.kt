package com.example.finalproject.view.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding
import com.example.finalproject.view.ui.adapter.HomeAdapter
import com.example.finalproject.model.ItemDestinasi
import com.example.finalproject.model.datastore.PassengersPreferences
import com.example.finalproject.view.ui.bottomsheet.BottomSheetFragment
import com.example.finalproject.view.ui.bottomsheetdatepicker.BottomSheetDatePickerFragment
import com.example.finalproject.view.ui.bottomsheetpenumpang.BottomSheetPenumpangFragment
import com.example.finalproject.view.ui.bottomsheetseatclass.BottomSheetSeatClassFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val homeVm: HomeViewModel by viewModels()
    lateinit var homePref : SharedPreferences
    lateinit var fromPref : SharedPreferences
    lateinit var toPref : SharedPreferences
    private lateinit var passengersPreferences: PassengersPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        fromPref = requireContext().getSharedPreferences("data_asal", Context.MODE_PRIVATE)
        toPref = requireContext().getSharedPreferences("data_tujuan", Context.MODE_PRIVATE)

        val token = homePref.getString("token", "")
        val from = fromPref.getString("city", "")
        val to = toPref.getString("city", "asdf")

        binding.tvPilihFrom.text = from
        binding.tvPilihTo.text = to


        Log.d("HomeFragment", "Token: $token")

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
//            BottomSheetFragment().show(requireActivity().supportFragmentManager,BottomSheetFragment.bottomTag)
            findNavController().navigate(R.id.action_homeFragment_to_bottomSheetFragment)
        }

        binding.tvPilihTo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bottomSheetTujuanFragment)
        }

        binding.setPassengers.setOnClickListener {
            BottomSheetPenumpangFragment().show(requireActivity().supportFragmentManager,BottomSheetPenumpangFragment.bottomTag)
        }
        binding.setReturn.setOnClickListener {
            BottomSheetDatePickerFragment().show(requireActivity().supportFragmentManager,BottomSheetDatePickerFragment.bottomTag)
        }
        binding.setDepature.setOnClickListener {
            BottomSheetDatePickerFragment().show(requireActivity().supportFragmentManager,BottomSheetDatePickerFragment.bottomTag)
        }
        binding.setSeat.setOnClickListener {
            BottomSheetSeatClassFragment().show(requireActivity().supportFragmentManager,BottomSheetSeatClassFragment.bottomTag)
        }

        binding.btnSwitch.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked){
                binding.setDepature.isEnabled =true
                binding.setReturn.isEnabled = true
                binding.setReturn.setTextColor(resources.getColor(R.color.darkblue05))
            }else{
                binding.setDepature.isEnabled = true
                binding.setReturn.isEnabled = false
                binding.setReturn.setTextColor(resources.getColor(R.color.neutral03))
            }
        }

        binding.ivSwitch.setOnClickListener {
            val fromText = binding.tvPilihFrom.text.toString()
            val toText = binding.tvPilihTo.text.toString()

            binding.tvPilihFrom.text = toText
            binding.tvPilihTo.text = fromText
        }

        homeVm.getPassenger().observe(viewLifecycleOwner){
            if(it != null) binding.setPassengers.text = "$it Penumpang"
        }

    }




}