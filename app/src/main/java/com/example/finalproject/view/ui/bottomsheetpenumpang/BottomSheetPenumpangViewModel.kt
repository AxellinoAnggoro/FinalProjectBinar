package com.example.finalproject.view.ui.bottomsheetpenumpang

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.datastore.PassengersPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetPenumpangViewModel @Inject constructor (private val preferences : PassengersPreferences): ViewModel() {

    fun setPassenger(input: String) = viewModelScope.launch { preferences.setPassenger(input) }

}