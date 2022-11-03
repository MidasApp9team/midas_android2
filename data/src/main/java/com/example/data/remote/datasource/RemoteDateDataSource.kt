package com.example.data.remote.datasource

import com.example.domain.entity.DateEntity

interface RemoteDateDataSource {
    suspend fun putDate(dateEntity: DateEntity)
}