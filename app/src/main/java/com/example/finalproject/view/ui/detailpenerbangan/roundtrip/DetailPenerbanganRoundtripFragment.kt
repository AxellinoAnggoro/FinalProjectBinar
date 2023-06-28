package com.example.finalproject.view.ui.detailpenerbangan.roundtrip

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentDetailPenerbanganRoundtripBinding
import com.example.finalproject.view.ui.detailpenerbangan.DetailPenerbanganViewModel
import com.example.finalproject.view.ui.home.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPenerbanganRoundtripFragment : Fragment() {
    lateinit var binding : FragmentDetailPenerbanganRoundtripBinding
    lateinit var detailVm : DetailPenerbanganViewModel
    private val homeVm : HomeViewModel by viewModels()
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganRoundtripBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireContext().getSharedPreferences("login_data",Context.MODE_PRIVATE)

        val sectionPagerAdapter = SectionPagerAdapter(activity as AppCompatActivity)
        binding.viewPager.adapter = sectionPagerAdapter
        TabLayoutMediator(binding.tabs,binding.viewPager){
                tab,position ->  tab.text = resources.getString(
            TAB_TITLES[position]
        )
        }.attach()

        binding.btnPilih.setOnClickListener {
            homeVm.saveIdTicket(id!!)
            if (pref.getString("token", "").toString().isNotEmpty()) {
                if (findNavController().currentDestination!!.id == R.id.detailPenerbanganRoundtripFragment) {

                    findNavController().navigate(R.id.action_detailPenerbanganRoundtripFragment_to_biodataPemesanFragment)

                }

            } else {
                val fragId = findNavController().currentDestination?.id
                findNavController().popBackStack(fragId!!, true)
                findNavController().navigate(R.id.bottomSheetLogin)
            }
        }
    }

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.string.str_pergi,
            R.string.str_pulang
        )
    }
}