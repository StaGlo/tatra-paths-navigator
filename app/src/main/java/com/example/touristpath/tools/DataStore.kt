package com.example.touristpath.tools


import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "show_stopper_prefs")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    fun getStopperVisibility(pathId: String): Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[booleanPreferencesKey("stopper_visibility_$pathId")] ?: false
    }

    suspend fun setStopperVisibility(pathId: String, isVisible: Boolean) {
        dataStore.edit { prefs ->
            prefs[booleanPreferencesKey("stopper_visibility_$pathId")] = isVisible
        }
    }

    fun getStopperValue(pathId: String): Flow<Double> = dataStore.data.map { prefs ->
        prefs[doublePreferencesKey("stopper_value_$pathId")] ?: 0.0
    }

    suspend fun setStopperValue(pathId: String, value: Double) {
        dataStore.edit { prefs ->
            prefs[doublePreferencesKey("stopper_value_$pathId")] = value
        }
    }
}