package com.example.finalproject.model.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences
import javax.inject.Inject

class PassengersPreferences @Inject constructor(private val datastore: DataStore<androidx.datastore.preferences.core.Preferences>){
    companion object {
        private val Context.datastore by preferencesDataStore( name = "DATASTORE" )
    }

    suspend fun setPassenger(input: String){
        datastore.edit {
            it[stringPreferencesKey("passenger")] = input
        }
    }

    fun getPassenger(): Flow<String> = datastore.data.map {
        it[stringPreferencesKey("passenger")] ?: ""
    }

    suspend fun setSeat(seat:String){
        datastore.edit {
            it[stringPreferencesKey("seatClass")] = seat
        }
    }

    fun getSeat():Flow<String> = datastore.data.map {
        it[stringPreferencesKey("seatClass")] ?:""
    }

    suspend fun setTanggalKeberangkatan(date:String){
        datastore.edit {
            it[stringPreferencesKey("tanggalKeberangkatan")] = date
        }
    }
    fun getTanggalKeberangkatan():Flow<String> = datastore.data.map {
        it[stringPreferencesKey("tanggalKeberangkatan")] ?:""
    }

    suspend fun setTanggalPulang(date: String){
        datastore.edit {
            it[stringPreferencesKey("tanggalPulang")] = date
        }
    }

    fun getTanggalPulang():Flow<String> = datastore.data.map {
        it[stringPreferencesKey("tanggalPulang")] ?:""
    }
}
