package com.example.data.remote.api

import com.example.data.remote.request.DateRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface DateAPI {

    @POST("schedule/create")
    suspend fun putDate(
        @Body dateRequest: DateRequest
    )
}