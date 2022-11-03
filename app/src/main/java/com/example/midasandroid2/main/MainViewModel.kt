package com.example.midasandroid2.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.DateEntity
import com.example.domain.repository.TimeRepository
import com.example.domain.usecase.DateUseCase
import com.example.midasandroid2.base.BaseViewModel
import com.example.midasandroid2.main.compose.date
import com.example.midasandroid2.main.compose.time
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dateUseCase: DateUseCase
): ViewModel() {

    private val _success: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val success: MutableLiveData<Boolean> = _success

    val fail: MutableLiveData<Boolean> = MutableLiveData()

    fun putDate(dateEntity: DateEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                dateUseCase.execute(dateEntity)
            }.onSuccess {
                success.value = true
            }.onFailure {
                fail.value = true
            }
        }
    }
}