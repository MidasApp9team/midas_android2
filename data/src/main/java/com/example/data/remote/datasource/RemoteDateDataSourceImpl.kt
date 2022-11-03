package com.example.data.remote.datasource

import com.example.data.remote.api.DateAPI
import com.example.data.remote.request.toRequest
import com.example.domain.entity.DateEntity
import javax.inject.Inject

class RemoteDateDataSourceImpl @Inject constructor(
    private val dateAPI: DateAPI
): RemoteDateDataSource{
    override suspend fun putDate(dateEntity: DateEntity) = dateAPI.putDate(dateEntity.toRequest())
}