package com.example.midasandroid2.sign

import com.example.domain.entity.SignInEntity
import com.example.domain.exception.BadRequestException
import com.example.domain.exception.NotFoundException
import com.example.domain.exception.ServerException
import com.example.domain.param.SignInParam
import com.example.domain.usecase.sign.SignInUseCase
import com.example.midasandroid2.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
):BaseViewModel<SignInViewModel.Event>() {

    private val _token = MutableStateFlow(SignInParam("",""))
    val token: StateFlow<SignInParam> = _token

    fun signIn(signInEntity: SignInEntity) = execute(
        job = { signInUseCase.execute(signInEntity) },
        onSuccess = { _token.tryEmit(it) },
        onFailure = {
            when(it){
                is BadRequestException -> emitEvent(Event.BadRequest)
                is NotFoundException -> emitEvent(Event.NotFound)
                is ServerException -> emitEvent(Event.Server)
            }
        }
    )

    sealed class Event{
        object Success : Event()
        object BadRequest : Event()
        object NotFound : Event()
        object Server : Event()
    }
}