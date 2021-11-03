package com.example.karidmarket.presentation.login.di

import com.example.karidmarket.data.mapper.LoginEntityMapper
import com.example.karidmarket.data.repository.datasource.login.LoginDataSourceFactory
import com.example.karidmarket.data.repository.impl.LoginRepositoryImpl
import com.example.karidmarket.domain.repository.LoginRepository
import com.example.karidmarket.domain.usecase.GetUserLoginUseCase
import com.example.karidmarket.presentation.login.model.UserModelMapper
import com.example.karidmarket.presentation.login.viewmodel.LoginViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class LoginBuildModule {

    @Provides
    internal fun provideLoginViewModelFactory(
        useCase: GetUserLoginUseCase,
        mapper: UserModelMapper
    ) = LoginViewModelFactory(
        useCase, mapper
    )

    @Provides
    internal fun provideLoginRepository(
        factory: LoginDataSourceFactory,
        mapper: LoginEntityMapper
    ): LoginRepository = LoginRepositoryImpl(
        factory, mapper
    )

}