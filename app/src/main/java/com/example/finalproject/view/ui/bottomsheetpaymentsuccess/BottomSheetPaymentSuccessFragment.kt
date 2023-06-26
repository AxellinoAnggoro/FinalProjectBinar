package com.example.finalproject.view.ui.bottomsheetpaymentsuccess

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetPaymentSuccessBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPaymentSuccessFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentBottomSheetPaymentSuccessBinding
    companion object {
        val bottomTag : String = "bottomTag"
    }

    private lateinit var viewModel: BottomSheetPaymentSuccessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetPaymentSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            dismiss()
            findNavController().navigate(R.id.rincianPenerbanganFragment2)
        }
    }

}