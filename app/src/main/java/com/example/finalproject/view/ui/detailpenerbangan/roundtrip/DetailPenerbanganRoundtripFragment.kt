package com.example.finalproject.view.ui.detailpenerbangan.roundtrip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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
    lateinit var homeVm : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganRoundtripBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPagerAdapter = SectionPagerAdapter(activity as AppCompatActivity)
        binding.viewPager.adapter = sectionPagerAdapter
        TabLayoutMediator(binding.tabs,binding.viewPager){
                tab,position ->  tab.text = resources.getString(
            TAB_TITLES[position]
        )
        }.attach()
    }

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.string.str_pergi,
            R.string.str_pulang
        )
    }
}