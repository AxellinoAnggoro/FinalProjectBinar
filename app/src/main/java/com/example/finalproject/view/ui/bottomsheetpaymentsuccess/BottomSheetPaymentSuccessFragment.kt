package com.example.finalproject.view.ui.bottomsheetpaymentsuccess

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R

class BottomSheetPaymentSuccessFragment : Fragment() {

    companion object {
        fun newInstance() = BottomSheetPaymentSuccessFragment()
    }

    private lateinit var viewModel: BottomSheetPaymentSuccessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_payment_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomSheetPaymentSuccessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}