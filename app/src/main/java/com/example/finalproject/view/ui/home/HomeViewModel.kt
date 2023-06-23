package com.example.finalproject.view.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalproject.model.datastore.PassengersPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.prefs.Preferences
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val preferences: PassengersPreferences) : ViewModel() {
    fun getPassenger(): LiveData<String> = preferences.getPassenger().asLiveData()

    fun getTanggalBerangkat():LiveData<String> = preferences.getTanggalKeberangkatan().asLiveData()

    fun getTanggalPulang():LiveData<String> = preferences.getTanggalPulang().asLiveData()

    fun getSeatClass():LiveData<String> = preferences.getSeat().asLiveData()
}