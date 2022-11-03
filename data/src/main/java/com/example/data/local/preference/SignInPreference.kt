package com.example.data.local.preference

interface SignInPreference {

    suspend fun saveNum(num: Int)
    suspend fun savePassword(password: String)

    suspend fun fetchNum(): Int
    suspend fun fetchPassword(): String
}