package com.example.midasandroid2.main.compose

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun date(): String{
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return current.format(formatter)
}

fun time(): String{
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return current.format(formatter)
}