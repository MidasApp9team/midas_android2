package com.example.domain.repository

import com.example.domain.entity.DateEntity

interface DateRepository {
    suspend fun putData(dateEntity: DateEntity)
}