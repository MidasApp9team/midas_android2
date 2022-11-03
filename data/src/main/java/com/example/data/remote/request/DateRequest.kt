package com.example.data.remote.request

import com.example.domain.entity.DateEntity

data class DateRequest(
    val useridx: Int,
    val type: String,
    val date: String,
    val start_time: String,
    val stop_time: String
)

fun DateEntity.toRequest() = DateRequest(
    useridx = 10,
    type = "sw",
    date = date,
    start_time = start_time,
    stop_time = stop_time
)
