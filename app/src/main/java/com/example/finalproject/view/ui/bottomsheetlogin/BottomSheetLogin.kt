package com.example.finalproject.view.ui.bottomsheetlogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetLogin : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBottomSheetLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(R.id.action_bottomSheetLogin_to_loginFragment)
    }


}