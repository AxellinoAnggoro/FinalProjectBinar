package com.example.finalproject.view.ui.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNonLoginHistoryBinding

class NonLoginHistoryFragment : Fragment() {

    lateinit var binding : FragmentNonLoginHistoryBinding

    private lateinit var viewModel: NonLoginHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_nonLoginHistoryFragment_to_loginFragment)
        }
    }



}