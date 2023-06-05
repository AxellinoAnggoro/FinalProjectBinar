package com.example.finalproject.view.ui.bottomsheet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetFragment : Fragment() {

    companion object {
        fun newInstance() = BottomSheetFragment()
    }

    private lateinit var viewModel: BottomSheetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomSheetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}