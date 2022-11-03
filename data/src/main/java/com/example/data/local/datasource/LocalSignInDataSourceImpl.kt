package com.example.data.local.datasource

import com.example.data.local.preference.SignInPreference
import com.example.domain.entity.SignInEntity
import javax.inject.Inject

class LocalSignInDataSourceImpl @Inject constructor(
    private val signInPreference: SignInPreference
): LocalSignInDataSource {
    override suspend fun autoLogin(): SignInEntity =
        with(signInPreference){
            SignInEntity(
                num = fetchNum(),
                password = fetchPassword()
            )
        }
}