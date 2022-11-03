package com.example.data.local.preference

interface SignInPreference {
    suspend fun fetchNum(): Int
    suspend fun fetchPassword(): String
}