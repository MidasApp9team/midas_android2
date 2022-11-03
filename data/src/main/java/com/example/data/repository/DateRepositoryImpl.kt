package com.example.data.repository

import com.example.data.remote.datasource.RemoteDateDataSource
import com.example.domain.entity.DateEntity
import com.example.domain.repository.DateRepository
import javax.inject.Inject

class DateRepositoryImpl @Inject constructor(
    private val remoteDateDataSource: RemoteDateDataSource
): DateRepository {
    override suspend fun putData(dateEntity: DateEntity) = remoteDateDataSource.putDate(dateEntity)
}