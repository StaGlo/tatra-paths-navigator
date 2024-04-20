package com.example.touristpath.tools


import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "show_stopper_prefs")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    fun getStopperState(pathId: String): Flow<Boolean> =
        dataStore.data.map { prefs ->
            prefs[booleanPreferencesKey("stopper_$pathId")] ?: false
        }

    suspend fun setStopperState(pathId: String, state: Boolean) {
        dataStore.edit { prefs ->
            prefs[booleanPreferencesKey("stopper_$pathId")] = state
        }
    }
}