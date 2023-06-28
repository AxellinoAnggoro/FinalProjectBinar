package com.example.finalproject.view.ui.detailpenerbangan.roundtrip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentDetailPergiBinding


class DetailPergiFragment : Fragment() {
    lateinit var binding : FragmentDetailPergiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPergiBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}