package com.example.finalproject.view.ui.bottomsheetpenumpang

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetPenumpangBinding
import com.example.finalproject.model.datastore.PassengersPreferences
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetPenumpangFragment : BottomSheetDialogFragment() {

    private lateinit var passengersPreferences: PassengersPreferences
    lateinit var binding : FragmentBottomSheetPenumpangBinding
    private val passengerVm: BottomSheetPenumpangViewModel by viewModels()

    private lateinit var dataStorePreferences : PassengersPreferences
    private val _passengerData = MutableLiveData<String>()
    val passengerData : LiveData<String> = _passengerData

    private var countDewasa = 0
    private var countAnak = 0
    private var countBayi = 0

    companion object {
        val bottomTag : String = "TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetPenumpangBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.btnSimpan.setOnClickListener {
            passengerVm.setPassenger((countDewasa + countAnak + countBayi).toString())
            dismiss()

        }
        countAdult()
        countChild()
        countBaby()


    }

    private fun countAdult(){
        //dewasa
        binding.icMinus.setOnClickListener {
            if (countDewasa > 0){
                countDewasa--
                binding.input.text = countDewasa.toString()
            }
        }

        binding.icPlus.setOnClickListener {
            countDewasa++
            binding.input.text = countDewasa.toString()
        }
    }

    private fun countChild(){
        //anak-anak
        binding.icMinus2.setOnClickListener {
            if (countAnak > 0){
                countAnak--
                binding.input2.text = countAnak.toString()
            }
        }

        binding.icPlus2.setOnClickListener {
            countAnak++
            binding.input2.text = countAnak.toString()
        }
    }

    private fun countBaby(){
        //bayi
        binding.icMinus3.setOnClickListener {
            if (countBayi > 0){
                countBayi--
                binding.input3.text = countBayi.toString()
            }
        }

        binding.icPlus3.setOnClickListener {
            countBayi++
            binding.input3.text = countBayi.toString()
        }
    }




}