package com.inova.mobile.bdilproductlist.preference

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    private val APP_PREF = "appPrefOne"
    private val preferences: SharedPreferences = context.getSharedPreferences(APP_PREF,Context.MODE_PRIVATE)

    private val PREF_PRIMARY_COLOR = "primaryColor"
    private val PREF_LIGHT_TEXT_COLOR = "lightTextColor"
    private val PREF_DARK__TEXT_COLOR = "darkTextColor"
    private val PREF_GREY_TEXT_COLOR = "greyTextColor"

    var primaryColorPref: Int
        get() = preferences.getInt(PREF_PRIMARY_COLOR, 0)
        set(value) = preferences.edit().putInt(PREF_PRIMARY_COLOR, value).apply()
    var lightTextColorPref: Int
        get() = preferences.getInt(PREF_LIGHT_TEXT_COLOR, 0)
        set(value) = preferences.edit().putInt(PREF_LIGHT_TEXT_COLOR, value).apply()
    var darkTextColorPref: Int
        get() = preferences.getInt(PREF_DARK__TEXT_COLOR, 0)
        set(value) = preferences.edit().putInt(PREF_DARK__TEXT_COLOR, value).apply()
    var greyTextColorPref: Int
        get() = preferences.getInt(PREF_GREY_TEXT_COLOR, 0)
        set(value) = preferences.edit().putInt(PREF_GREY_TEXT_COLOR, value).apply()
}