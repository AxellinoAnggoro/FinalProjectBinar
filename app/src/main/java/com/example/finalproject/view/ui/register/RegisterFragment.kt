package com.example.finalproject.view.ui.register

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var regisVm: RegisterViewModel
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regisVm = ViewModelProvider(this)[RegisterViewModel::class.java]
        pref = requireContext().getSharedPreferences("data_regis", Context.MODE_PRIVATE)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.btnDaftar.setOnClickListener {
            authRegister()
        }
    }

    fun authRegister() {
        val name = binding.inputName.text.toString()
        val email = binding.inputEmail.text.toString()
        val password = binding.inputPassword.text.toString()
        val phone = binding.inputPhone.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.inputRegEmailLay.error = "Invalid Email"
            binding.inputRegEmailLay.requestFocus()
            return
        } else if (phone.isEmpty()) {
            binding.inputRegNoTelp.error = "Phone still empty"
            binding.inputRegNoTelp.requestFocus()
        } else if (name.isEmpty()) {
            binding.inputRegNamaLay.error = "Name still empty"
            binding.inputRegNamaLay.requestFocus()
            return
        } else if (password.length < 8) {
            binding.inputRegPassLay.error = "Minimum password length is 8"
            binding.inputRegPassLay.requestFocus()
            return
        } else {
            regisVm.addDataRegis(name, email, password, phone)
            regisVm.responseRegister.observe(viewLifecycleOwner) {
                if (it.status == "success") {
                    val dataEmail = it.data.newUserResponse.email
                    val dataPhone = it.data.newUserResponse.phoneNumber
                    val dataName = it.data.newUserResponse.name
                    storeEmail(dataEmail, dataPhone, dataName)
                    Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_otpFragment)
                } else {
                    Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun storeEmail(email : String, phone : String, name : String){
        val save = pref.edit()
        save.putString("email", email)
        save.putString("phone", phone)
        save.putString("name", name)
        save.apply()
    }
}