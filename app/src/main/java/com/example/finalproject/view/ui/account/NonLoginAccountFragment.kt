package com.example.finalproject.view.ui.account

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNonLoginAccountBinding

class NonLoginAccountFragment : Fragment() {

    lateinit var binding : FragmentNonLoginAccountBinding
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNonLoginAccountBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val token = pref.getString("token", "")

        if (token != null) {
            findNavController().navigate(R.id.action_nonLoginAccountFragment_to_accountFragment)
        }

        binding.btnMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_nonLoginAccountFragment_to_loginFragment)
        }


    }



}