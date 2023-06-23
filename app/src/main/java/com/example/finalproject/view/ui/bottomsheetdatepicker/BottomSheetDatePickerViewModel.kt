package com.example.finalproject.view.ui.bottomsheetdatepicker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.datastore.PassengersPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetDatePickerViewModel @Inject constructor(private val preferences: PassengersPreferences): ViewModel() {

    fun setTanggalKeberangkatan(date:String) = viewModelScope.launch(Dispatchers.IO){preferences.setTanggalKeberangkatan(date)}

    fun setTanggalPulang(date: String) = viewModelScope.launch(Dispatchers.IO){preferences.setTanggalPulang(date)}
}