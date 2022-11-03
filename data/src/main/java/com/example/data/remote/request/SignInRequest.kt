package com.example.data.remote.request

import com.example.domain.entity.SignInEntity

data class SignInRequest(
    val num: Int,
    val password: String
)

fun SignInEntity.toRequest() = SignInRequest(
    num = num,
    password = password
)
