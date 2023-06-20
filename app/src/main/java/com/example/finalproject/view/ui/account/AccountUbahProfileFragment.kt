package com.example.finalproject.view.ui.account

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentAccountUbahProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountUbahProfileFragment : Fragment() {

    lateinit var binding : FragmentAccountUbahProfileBinding
    lateinit var accountVm : AccountViewModel
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountUbahProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountVm = ViewModelProvider(this)[AccountViewModel::class.java]
        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)

        binding.btnUpdate.setOnClickListener {
            updateUser()
        }
    }

    private fun updateUser() {
        val token = pref.getString("token", "").toString()

        val name = binding.inputName.text.toString()
        val email = binding.inputEmail.text.toString()
        val phoneNumber = binding.inputPhone.text.toString()

        accountVm.updateProfile(token,name, email, phoneNumber)
        accountVm.liveDataProfile.observe(viewLifecycleOwner){
            if (it != null){
                Toast.makeText(context, "Profile Updated", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.accountubah)
            }else{
                Toast.makeText(context, "Profile Update Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}