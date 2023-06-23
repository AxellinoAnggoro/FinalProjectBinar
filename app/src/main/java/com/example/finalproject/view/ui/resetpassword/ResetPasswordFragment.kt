package com.example.finalproject.view.ui.resetpassword

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentResetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {

    private lateinit var binding : FragmentResetPasswordBinding
    private lateinit var resetVm: ResetPasswordViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resetVm = ViewModelProvider(this)[ResetPasswordViewModel::class.java]

        binding.btnSimpan.setOnClickListener {
            authResetPass()
            findNavController().navigate(R.id.action_resetPasswordFragment_to_loginFragment)
        }
    }

    fun authResetPass(){
        val email = binding.inputEmail.text.toString()
        val password = binding.inputPassword.text.toString()
        val confPassword = binding.inputConfPassword.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.inputEmailLay.error = "Invalid Email"
            binding.inputEmailLay.requestFocus()
            return
        }else if (password.length < 8){
            binding.inputMasukkanPasswordBaruLay.error = "Minimum password length is 8"
            binding.inputMasukkanPasswordBaruLay.requestFocus()
            return
        }else if (password != confPassword){
            binding.inputUlangMasukkanPasswordBaruLay.error = "Password Tidak Sesuai"
            binding.inputUlangMasukkanPasswordBaruLay.requestFocus()
            return
        }else{
            resetVm.updateDataPassword(email, password)
            resetVm.postResetPass.observe(viewLifecycleOwner){
                if (it.status == "success"){
                    Toast.makeText(context, "Reset password berhasil!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Reset password gagal!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}