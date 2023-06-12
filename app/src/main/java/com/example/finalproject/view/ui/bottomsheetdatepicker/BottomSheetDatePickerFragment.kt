package com.example.finalproject.view.ui.bottomsheetdatepicker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDatePickerFragment : BottomSheetDialogFragment() {


    companion object{
        val bottomTag : String = "TAG_DATE_PICKER"
    }
    private lateinit var viewModel: BottomSheetDatePickerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet_date_picker, container, false)
    }



}