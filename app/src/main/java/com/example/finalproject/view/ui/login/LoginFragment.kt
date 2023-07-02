package com.example.finalproject.view.ui.login

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentLoginBinding
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var loginVm : LoginViewModel
    lateinit var loginPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginVm = ViewModelProvider(this)[LoginViewModel::class.java]
        loginPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)

        binding.btnMasuk.setOnClickListener {
            authLogin()
        }

        binding.tvLupasPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }

        binding.tvDaftarDisini.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun authLogin() {
        val email = binding.inputEmail.text.toString()
        val password = binding.inputPassword.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.inputEmailLay.error = "Invalid Email"
            binding.inputEmailLay.requestFocus()
            return
        }else if (password.isEmpty()){
            binding.inputPassLay.error = "Password is empty"
            binding.inputPassLay.requestFocus()
            return
        }else{
            loginVm.authorizeLogin(email, password)
            loginVm.responseLogin.observe(viewLifecycleOwner){ response ->
                if (response.status == "Success"){
//                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                    val token = response.data.token
                    storeToken(token)
                    allertLoginSuccess()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    allertLoginFailed()
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun storeToken(token : String){
        val save = loginPref.edit()
        save.putString("token", token)
        save.apply()
    }

    private fun allertLoginSuccess(){
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_allert_success,requireView().findViewById(R.id.customAllertSuccess))

        val textView = layout.findViewById<MaterialTextView>(R.id.tvAllert)
        textView.text = "Login Berhasil"
        val toast = Toast(requireContext())
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
    private fun allertLoginFailed(){
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_allert_success,requireView().findViewById(R.id.customAllertSuccess))

        val textView = layout.findViewById<MaterialTextView>(R.id.tvAllert)
        textView.text = "Login Gagal"
        val toast = Toast(requireContext())
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}