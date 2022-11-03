package com.example.data.local.preference

import android.content.SharedPreferences
import com.example.data.local.helper.SharedPreferenceHelper
import javax.inject.Inject

class SignInPreferenceImpl @Inject constructor(
    private val s: SharedPreferenceHelper
): SignInPreference {

    override suspend fun fetchNum(): Int =
        s.fetchIntPreference(NUM,0)

    override suspend fun fetchPassword(): String =
        s.fetchStringPreference(PASSWORD)

    companion object Key{
        const val NUM = "NUM"
        const val PASSWORD = "PASSWORD"
    }
}