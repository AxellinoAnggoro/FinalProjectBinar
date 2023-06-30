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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding
import com.example.finalproject.model.ItemDestinasi
import com.example.finalproject.model.datastore.PassengersPreferences
import com.example.finalproject.model.flight.DataFlight
import com.example.finalproject.view.ui.bottomsheet.BottomSheetFragment
import com.example.finalproject.view.ui.bottomsheet.BottomSheetTujuanFragment
import com.example.finalproject.view.ui.bottomsheetdatepicker.BottomSheetDatePickerFragment
import com.example.finalproject.view.ui.bottomsheetpenumpang.BottomSheetPenumpangFragment
import com.example.finalproject.view.ui.bottomsheetseatclass.BottomSheetSeatClassFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
//    private var homeVm: HomeViewModel by viewModels()
    lateinit var homeVm : HomeViewModel
    lateinit var homePref : SharedPreferences
    lateinit var fromPref : SharedPreferences
    lateinit var toPref : SharedPreferences
    lateinit var passengerPref : SharedPreferences
    lateinit var classPref : SharedPreferences
    lateinit var departurePref: SharedPreferences
    lateinit var arrivalPref :SharedPreferences
    lateinit var fromInput : SharedPreferences
    lateinit var toInput : SharedPreferences
    lateinit var roundtripPref :SharedPreferences

    companion object{
        var isSwitchOn = false
    }

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
        passengerPref = requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
        classPref = requireContext().getSharedPreferences("data_class", Context.MODE_PRIVATE)
        departurePref = requireContext().getSharedPreferences("data_berangkat", Context.MODE_PRIVATE)
        arrivalPref = requireContext().getSharedPreferences("data_pulang", Context.MODE_PRIVATE)
        fromInput = requireContext().getSharedPreferences("input_from", Context.MODE_PRIVATE)
        toInput = requireContext().getSharedPreferences("input_to", Context.MODE_PRIVATE)
//        roundtripPref = requireContext().getSharedPreferences("roundtrip", Context.MODE_PRIVATE)


        val token = homePref.getString("token", "")
        val from = fromPref.getString("city", "")
        val to = toPref.getString("city", "")

        binding.tvPilihFrom.text = from
        Log.d("HomeFragment", "from: $from")
        binding.tvPilihTo.text = to
        Log.d("HomeFragment", "to: $to")


        Log.d("HomeFragment", "Token: $token")

//        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false)
//        binding.rvDestinasi.layoutManager = layoutManager
//        val itemDestinasi = listOf(
//            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
//            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
//            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000"),
//            ItemDestinasi(R.drawable.iv_destinasi,"Jakarta -> Bangkok","AirAsia","20 Mei 2023","Rp.2000.000")
//        )
//        homeAdapter = HomeAdapter(itemDestinasi)
//        binding.rvDestinasi.adapter = homeAdapter

        homeAdapter = HomeAdapter(emptyList())
        binding.rvDestinasi.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = homeAdapter
        }

        homeVm = ViewModelProvider(this)[HomeViewModel::class.java]
        homeVm.fetchFav()
        homeVm.liveDataFav.observe(viewLifecycleOwner){ dataFavList->
            dataFavList?.let { fav->
                homeAdapter.updateData(fav as List<DataFlight>)
            }
        }


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

        binding.btnSwitch.setOnCheckedChangeListener{_, isChecked -> isSwitchOn = isChecked
            if (isChecked){
                binding.btnRoundTrip.visibility = View.VISIBLE
            }else{
                binding.btnRoundTrip.visibility = View.GONE
            }
//            val save = roundtripPref.edit()
//            save.putBoolean("roundtrip_status", isSwitchOn)
//            Log.d("roundtrip", isSwitchOn.toString())
//            save.apply()
        }

        binding.btnRoundTrip.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nonLoginHasilPencarianRoundFragment)
        }

        binding.ivSwitch.setOnClickListener {
            val fromText = binding.tvPilihFrom.text.toString()
            val toText = binding.tvPilihTo.text.toString()

            binding.tvPilihFrom.text = toText
            binding.tvPilihTo.text = fromText
        }

        homeVm.getPassenger().observe(viewLifecycleOwner){
            if(it != null) binding.setPassengers.text = "$it Penumpang"
            val save = passengerPref.edit()
            save.putString("passenger", it)
            save.apply()
            Log.d("Home Frag", "$it penumpang")
        }
        setTanggalKeberangkatan()
        setTanggalPulang()
        setSeatClass()

    }

    private fun setSeatClass() {
        homeVm.getSeatClass().observe(viewLifecycleOwner){
            if (it != ""){
                binding.setSeat.text =it
                binding.setSeat.setTextColor(ContextCompat.getColor(requireContext(),R.color.neutral05))
                val save = classPref.edit()
                save.putString("class", it)
                save.apply()
            }
        }
    }

    private fun setTanggalPulang() {
        homeVm.getTanggalPulang().observe(viewLifecycleOwner){
            if (it!=""){
                binding.setReturn.text = it.substringAfter(", ")
                binding.setReturn.setTextColor(ContextCompat.getColor(requireContext(),R.color.neutral05))
                val save = arrivalPref.edit()
                save.putString("arrival", it)
                save.apply()
            }
        }
    }

    private fun setTanggalKeberangkatan() {
        homeVm.getTanggalBerangkat().observe(viewLifecycleOwner){
            if (it!=""){
                binding.setDepature.text = it.substringAfter(", ")
                binding.setDepature.setTextColor(ContextCompat.getColor(requireContext(),R.color.neutral05))
                val save = departurePref.edit()
                save.putString("departure", it)
                Log.d("departure", "departure: $it")
                save.apply()
            }
        }
    }


}