package com.example.midasandroid2.sign

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.SignInEntity
import com.example.domain.exception.BadRequestException
import com.example.domain.exception.NotFoundException
import com.example.domain.exception.ServerException
import com.example.domain.param.SignInParam
import com.example.domain.usecase.sign.SaveSignUseCase
import com.example.domain.usecase.sign.SignInUseCase
import com.example.midasandroid2.base.BaseViewModel
import com.example.midasandroid2.util.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val saveSignUseCase: SaveSignUseCase
) : ViewModel(){

    private val _loginSuccess: MutableLiveData<String> = MutableLiveData<String>()
    val loginSuccess: MutableLiveData<String> = _loginSuccess
    private val _loginFail: MutableLiveData<String> = MutableLiveData<String>()
    val loginFail: MutableLiveData<String> = _loginFail

    fun signIn(signInEntity: SignInEntity) {
        viewModelScope.launch {
            kotlin.runCatching {
                signInUseCase.execute(signInEntity)
            }.onSuccess {
                _loginSuccess.value = it
            }.onFailure {
                _loginFail.value = it.toString()
            }
        }
    }


}