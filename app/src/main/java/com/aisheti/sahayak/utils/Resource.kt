package com.aisheti.sahayak.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// ─── Resource ─────────────────────────────────────────────────────────────────

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
    class Loading<T> : Resource<T>()
}

// ─── Preferences ──────────────────────────────────────────────────────────────

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sheti_prefs")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        val LANGUAGE_KEY = stringPreferencesKey("selected_language")
        val LANGUAGE_CODE_KEY = stringPreferencesKey("language_code")
        val IS_FIRST_LAUNCH_KEY = booleanPreferencesKey("is_first_launch")
    }

    val selectedLanguage: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[LANGUAGE_KEY] ?: "English"
    }

    val languageCode: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[LANGUAGE_CODE_KEY] ?: "en"
    }

    val isFirstLaunch: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[IS_FIRST_LAUNCH_KEY] ?: true
    }

    suspend fun saveLanguage(language: String, code: String) {
        context.dataStore.edit { prefs ->
            prefs[LANGUAGE_KEY] = language
            prefs[LANGUAGE_CODE_KEY] = code
        }
    }

    suspend fun setFirstLaunchDone() {
        context.dataStore.edit { prefs ->
            prefs[IS_FIRST_LAUNCH_KEY] = false
        }
    }
}

// ─── Language Config ──────────────────────────────────────────────────────────

data class Language(
    val name: String,
    val nativeName: String,
    val code: String,
    val flag: String
)

object Languages {
    val all = listOf(
        Language("English", "English", "en", "🇬🇧"),
        Language("Marathi", "मराठी", "mr", "🇮🇳"),
        Language("Hindi", "हिंदी", "hi", "🇮🇳"),
        Language("Gujarati", "ગુજરાતી", "gu", "🇮🇳"),
        Language("Punjabi", "ਪੰਜਾਬੀ", "pa", "🇮🇳"),
        Language("Tamil", "தமிழ்", "ta", "🇮🇳"),
        Language("Telugu", "తెలుగు", "te", "🇮🇳"),
        Language("Kannada", "ಕನ್ನಡ", "kn", "🇮🇳")
    )
}
