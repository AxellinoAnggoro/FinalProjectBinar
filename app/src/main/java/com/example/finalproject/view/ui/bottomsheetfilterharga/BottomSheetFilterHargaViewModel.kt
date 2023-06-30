package com.example.finalproject.view.ui.bottomsheetfilterharga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.model.datastore.PassengersPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetFilterHargaViewModel @Inject constructor(private val preferces:PassengersPreferences) : ViewModel() {

    fun setFilter(filter:String) = viewModelScope.launch(Dispatchers.IO){
        preferces.setSelectFilter(filter)
    }
}