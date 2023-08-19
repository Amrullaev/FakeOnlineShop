package com.example.fakeonlineshop

import android.app.Application
import android.content.ContentValues
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(ContentValues.TAG, "onCreate: App create")
    }
}