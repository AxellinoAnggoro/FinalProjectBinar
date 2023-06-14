package com.example.finalproject.view.ui.bottomsheetpenumpang

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetPenumpangBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPenumpangFragment : BottomSheetDialogFragment() {

    companion object {
        val bottomTag : String = "TAG"
    }
    lateinit var binding : FragmentBottomSheetPenumpangBinding

    private var count = 0


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

        //dewasa
        binding.icMinus.setOnClickListener {
            if (count > 0){
                count--
                binding.input.text = count.toString()
            }
        }

        binding.icPlus.setOnClickListener {
            count++
            binding.input.text = count.toString()
        }

        //anak
        binding.icMinus2.setOnClickListener {
            if (count > 0){
                count--
                binding.input2.text = count.toString()
            }
        }

        binding.icPlus2.setOnClickListener {
            count++
            binding.input2.text = count.toString()
        }

        //bayi
        binding.icMinus3.setOnClickListener {
            if (count > 0){
                count--
                binding.input3.text = count.toString()
            }
        }

        binding.icPlus3.setOnClickListener {
            count++
            binding.input3.text = count.toString()
        }
    }




}