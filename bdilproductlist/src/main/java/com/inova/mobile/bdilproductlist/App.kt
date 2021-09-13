package com.inova.mobile.bdilproductlist

import android.app.Application
import com.inova.mobile.bdilproductlist.preference.Prefs

val prefs: Prefs by lazy {
    App.prefs!!
}

class App: Application()
{
    companion object {
        var prefs: Prefs? = null
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        prefs = Prefs(applicationContext)
    }
}