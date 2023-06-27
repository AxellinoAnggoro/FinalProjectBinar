package com.example.finalproject.view.ui.checkout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBiodataPemesanBinding
import com.example.finalproject.model.BiodataPemesan
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BiodataPemesanFragment : Fragment() {
    lateinit var binding : FragmentBiodataPemesanBinding
    lateinit var pref : SharedPreferences
    lateinit var regPref :SharedPreferences
    lateinit var checkoutVm : CheckoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBiodataPemesanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        regPref = requireContext().getSharedPreferences("data_regis", Context.MODE_PRIVATE)
        checkoutVm = ViewModelProvider(this)[CheckoutViewModel::class.java]

        binding.btnSave.setOnClickListener {
            val token = pref.getString("token", "").toString()

            val dataName = binding.inputName.text.toString()
            val dataEmail = binding.inputEmail.text.toString()
            val dataPhone = binding.inputPhone.text.toString()

            val save = regPref.edit()
            save.putString("email", dataEmail)
            save.putString("name", dataName)
            save.putString("phone", dataPhone)
            save.apply()

            checkoutVm.updateProfile(token, dataName, dataEmail, dataPhone)
        }
    }

}