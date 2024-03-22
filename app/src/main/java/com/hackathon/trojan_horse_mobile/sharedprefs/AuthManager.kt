package com.hackathon.trojan_horse_mobile.sharedprefs


import android.content.Context
import android.content.SharedPreferences

object AuthManager {
    private const val PREF_NAME = "TokenPrefs"
    private const val KEY_TOKEN = "token"

    private lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveLog(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getLog(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    fun clearLog() {
        val editor = sharedPreferences.edit()
        editor.remove(KEY_TOKEN)
        editor.apply()
    }
    fun isLoggedIn(): Boolean {
        return true
    }

    fun isLoggedOut(): Boolean {
        return false
    }
}
