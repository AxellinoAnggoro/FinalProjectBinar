package com.example.finalproject.view.ui.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBiodataPemesanBinding

class BiodataPemesanFragment : Fragment() {
    lateinit var binding : FragmentBiodataPemesanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBiodataPemesanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}