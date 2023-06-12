package com.example.finalproject.view.ui.bottomsheetpenumpang

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetPenumpangBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPenumpangFragment : BottomSheetDialogFragment() {

    companion object {
        val bottomTag : String = "TAG"
    }
    lateinit var binding : FragmentBottomSheetPenumpangBinding

    var num = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetPenumpangBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adult
        binding.icPlus.setOnClickListener {
            num++
            binding.input.text = num.toString()
        }
        binding.icMinus.setOnClickListener {
            num--
            binding.input.text = num.toString()
        }
        //child
        binding.icPlus2.setOnClickListener {
            num++
            binding.input2.text = num.toString()
        }
        binding.icMinus2.setOnClickListener {
            num--
            binding.input2.text = num.toString()
        }
        //baby
        binding.icPlus3.setOnClickListener {
            num++
            binding.input3.text = num.toString()
        }
        binding.icMinus3.setOnClickListener {
            num--
            binding.input3.text = num.toString()
        }
    }



}