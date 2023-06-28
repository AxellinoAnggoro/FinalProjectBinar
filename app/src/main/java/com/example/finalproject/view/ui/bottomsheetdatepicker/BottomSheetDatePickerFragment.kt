package com.example.finalproject.view.ui.bottomsheetdatepicker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.archit.calendardaterangepicker.customviews.CalendarListener
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetDatePickerBinding
import com.example.finalproject.view.ui.home.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class BottomSheetDatePickerFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBottomSheetDatePickerBinding
    companion object{
        val bottomTag : String = "TAG_DATE_PICKER"
    }
    private val setDateViewModel: BottomSheetDatePickerViewModel by viewModels()
    private var tanggalBerangkat : String = " "
    private var tanggalPulang : String = " "
    private val tglFormat = SimpleDateFormat("d-M-YYYY", Locale("id,","ID"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetDatePickerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.icClose.setOnClickListener {
            dismiss()
        }

        if (HomeFragment.isSwitchOn){
            binding.calendar.visibility = View.VISIBLE
            binding.calendarSingel.visibility = View.GONE
        }else{
            binding.calendar.visibility = View.GONE
            binding.calendarSingel.visibility = View.VISIBLE
        }
        binding.btnPilih.setOnClickListener {
            binding.tvTanggalBerangkat.text = tanggalBerangkat
            binding.tvTanggalPulang.text = tanggalPulang
            setDateViewModel.apply {
                setTanggalKeberangkatan(tanggalBerangkat)
                if (tanggalPulang != "-") setTanggalPulang(tanggalPulang)
            }
            dismiss()
        }
        setDateRange()
        setDateSingel()
    }

    private fun setDateSingel() {
        binding.calendarSingel.setCalendarListener(object :CalendarListener{
            override fun onDateRangeSelected(startDate: Calendar, endDate: Calendar) {
                tanggalBerangkat = tglFormat.format(startDate.time)
                binding.setDate.text = tanggalBerangkat
                binding.setDate2.text ="-"
            }

            override fun onFirstDateSelected(startDate: Calendar) {
            }
        })
    }

    private fun setDateRange() {
        binding.calendar.setCalendarListener(object :CalendarListener{
            override fun onDateRangeSelected(startDate: Calendar, endDate: Calendar) {
                tanggalBerangkat = tglFormat.format(startDate.time)
                tanggalPulang = tglFormat.format(endDate.time)
                binding.setDate.text = tanggalBerangkat
                binding.setDate2.text = tanggalPulang
            }

            override fun onFirstDateSelected(startDate: Calendar) {

            }
        })
    }


}