package com.example.finalproject.view.ui.bottomsheet

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
import com.example.finalproject.databinding.FragmentBottomSheetBinding
import com.example.finalproject.databinding.FragmentBottomSheetTujuanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetTujuanFragment : Fragment() {
    lateinit var binding: FragmentBottomSheetTujuanBinding
    lateinit var bsheetVm: BottomSheetViewModel
    lateinit var pref : SharedPreferences



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetTujuanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bsheetVm = ViewModelProvider(this)[BottomSheetViewModel::class.java]
        bsheetVm.getCity()
        bsheetVm.liveDataFromTo.observe(viewLifecycleOwner) { airportList ->
            airportList?.let { airports ->
                binding.rvAsalTujuan.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvAsalTujuan.adapter = BottomSheetAdapter(airports.filterNotNull()){ city ->
                    storeCity(city)
                    findNavController().navigate(R.id.action_bottomSheetTujuanFragment_to_homeFragment)
                }

            }

//        binding.icBack.setOnClickListener {
//            dismiss()
//        }

        }
    }

    private fun storeCity(city: String) {
        pref = requireContext().getSharedPreferences("data_tujuan", Context.MODE_PRIVATE)
        val save = pref.edit()
        save.putString("city", city)
        save.apply()
        Log.d("BottomSheetTujuanFragment", "Selected City: $city")
    }
}