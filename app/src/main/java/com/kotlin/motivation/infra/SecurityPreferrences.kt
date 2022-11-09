package com.kotlin.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferrences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }
}