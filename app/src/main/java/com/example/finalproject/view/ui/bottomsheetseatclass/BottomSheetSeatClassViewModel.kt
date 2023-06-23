package com.example.finalproject.view.ui.bottomsheetseatclass

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.datastore.PassengersPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetSeatClassViewModel @Inject constructor(private val preferences: PassengersPreferences): ViewModel() {

    fun setSeat(seat:String) = viewModelScope.launch(Dispatchers.IO){
        preferences.setSeat(seat)
    }
}