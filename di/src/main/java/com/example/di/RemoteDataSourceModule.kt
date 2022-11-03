package com.example.di

import com.example.data.remote.datasource.RemoteDateDataSource
import com.example.data.remote.datasource.RemoteDateDataSourceImpl
import com.example.data.remote.datasource.RemoteSignInDataSource
import com.example.data.remote.datasource.RemoteSignInDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindRemoteSignInDataModule(
        remoteSignInDataSourceImpl: RemoteSignInDataSourceImpl
    ): RemoteSignInDataSource

    @Binds
    abstract fun bindRemoteDateDataModule(
        remoteDateDataSourceImpl: RemoteDateDataSourceImpl
    ): RemoteDateDataSource
}