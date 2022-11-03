package com.example.domain.usecase

import com.example.domain.entity.DateEntity
import com.example.domain.repository.DateRepository
import javax.inject.Inject

class DateUseCase @Inject constructor(
    private val dateRepository: DateRepository
): UseCase<DateEntity, Unit>(){
    override suspend fun execute(data: DateEntity) = dateRepository.putData(data)
}