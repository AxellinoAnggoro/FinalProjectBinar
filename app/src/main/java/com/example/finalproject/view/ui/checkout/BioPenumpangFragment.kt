package com.example.finalproject.view.ui.checkout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SharedMemory
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBioPenumpangBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BioPenumpangFragment : Fragment() {
    lateinit var binding: FragmentBioPenumpangBinding
    lateinit var bioVm: CheckoutViewModel
    lateinit var tokenPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBioPenumpangBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tokenPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        bioVm = ViewModelProvider(this)[CheckoutViewModel::class.java]

        binding.btnLanjutRincianPenerbangan.setOnClickListener {
            getInputPassenger()
        }

    }

    fun getInputPassenger() {
        val token = tokenPref.getString("token", "").toString()
        val name = binding.inputName.text.toString()
        val bornDate = binding.inputBorndate.text.toString()
        val citizen = binding.inputCitizen.text.toString()
        val idNumber = binding.inputIdNumber.text.toString()
        val country = binding.inputCountry.text.toString()

        if (name.isEmpty()) {
            binding.inputName.error = "Name Still Empty"
            binding.inputName.requestFocus()
            return
        } else if (bornDate.isEmpty()) {
            binding.inputBorndate.error = "Name Still Empty"
            binding.inputBorndate.requestFocus()
            return
        } else if (citizen.isEmpty()) {
            binding.inputCitizen.error = "Name Still Empty"
            binding.inputCitizen.requestFocus()
            return
        } else if (idNumber.isEmpty()) {
            binding.inputIdNumber.error = "Name Still Empty"
            binding.inputIdNumber.requestFocus()
            return
        } else if (country.isEmpty()) {
            binding.inputCountry.error = "Name Still Empty"
            binding.inputCountry.requestFocus()
            return
        } else {
            bioVm.addPassenger(token, name, bornDate, citizen, idNumber, country)
            bioVm.liveDataPassenger.observe(viewLifecycleOwner) {
                if (it != null) {
                    Toast.makeText(context, "Success Add Passenger", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_bioPenumpangFragment_to_rincianPenerbanganFragment2)
                }else{
                    Toast.makeText(context, "Fail Add Passenger", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}