package com.example.finalproject.view.ui.otp

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpFragment : Fragment() {

    private lateinit var binding: FragmentOtpBinding
    private lateinit var otpVm: OtpViewModel
    private lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOtpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = requireContext().getSharedPreferences("data_regis", Context.MODE_PRIVATE)
        otpVm = ViewModelProvider(this)[OtpViewModel::class.java]

        val email = pref.getString("email", "")

        Log.d("OtpFragment", "email: $email")

        binding.tvEmailOtp.text = email

        binding.btnVerifikasi.setOnClickListener {
            val otpText = binding.pinview.text.toString()
            if (otpText.isNotEmpty()) {
                val otp = otpText.toInt()
                verifyOtp(email!!, otp)
            } else {
                Toast.makeText(requireContext(), "OTP is empty", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun verifyOtp(email : String, otp :Int) {
        otpVm.verifyOtp(email, otp)
        otpVm.postDataOtp.observe(viewLifecycleOwner) {
            if (it.status == "success") {
                findNavController().navigate(R.id.action_otpFragment_to_loginFragment)
                Toast.makeText(requireContext(), "Verifikasi OTP Sukses", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Maaf, Kode OTP Salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}