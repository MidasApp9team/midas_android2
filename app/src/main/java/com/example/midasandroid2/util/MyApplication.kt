package com.example.midasandroid2.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

var ACCESS_TOKEN = ""
var owner = false

var start_time = ""
var stop_time = ""
var date = ""

@HiltAndroidApp
class MyApplication : Application()

fun ts(textView: TextView): String = textView.text.toString()


