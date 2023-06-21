package com.example.finalproject.model.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltPreferences {
    companion object{
        private val Context.datastore by preferencesDataStore(
            name = "DATASTORE_PREFERENCES"
        )
    }

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> = context.datastore


    @Singleton
    @Provides
    fun providePassengersPreferences(dataStore: DataStore<Preferences>): PassengersPreferences =
        PassengersPreferences(dataStore)
}