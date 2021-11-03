package com.example.karidmarket.presentation.signup.di

import com.example.karidmarket.data.mapper.RegisterEntityMapper
import com.example.karidmarket.data.repository.datasource.signup.RegisterDataSourceFactory
import com.example.karidmarket.data.repository.impl.RegisterRepositoryImpl
import com.example.karidmarket.domain.repository.RegisterRepository
import com.example.karidmarket.domain.usecase.GetRegisterUseCase
import com.example.karidmarket.presentation.signup.model.UserModelDataMapper
import com.example.karidmarket.presentation.signup.viewmodel.RegisterViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class RegisterBuildModule {

    @Provides
    internal fun provideViewModelFactory(
        registerUseCase: GetRegisterUseCase,
        mapper: UserModelDataMapper
    ) = RegisterViewModelFactory(registerUseCase, mapper)

    @Provides
    internal fun provideRegisterRepository(
        factory: RegisterDataSourceFactory,
        mapper: RegisterEntityMapper
    ): RegisterRepository = RegisterRepositoryImpl(factory, mapper)

}