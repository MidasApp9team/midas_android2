package com.example.midasandroid2.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

var ACCESS_TOKEN = ""

@HiltAndroidApp
class MyApplication : Application()

