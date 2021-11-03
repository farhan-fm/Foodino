package com.example.karidmarket.presentation.editprofile.di

import com.example.karidmarket.data.mapper.RegisterEntityMapper
import com.example.karidmarket.data.repository.datasource.editprofile.EditProfileDataSourceFactory
import com.example.karidmarket.data.repository.impl.EditProfileRepositoryImpl
import com.example.karidmarket.domain.repository.EditProfileRepository
import com.example.karidmarket.domain.usecase.GetEditProfileUseCase
import com.example.karidmarket.presentation.editprofile.model.UserModelDataMapper
import com.example.karidmarket.presentation.editprofile.viewmodel.EditProfileViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class EditProfileBuildModule {

    @Provides
    fun providesEditProfileViewModelFactory(
        editProfileUseCase: GetEditProfileUseCase,
        mapper: UserModelDataMapper
    ) = EditProfileViewModelFactory(editProfileUseCase, mapper)

    @Provides
    fun providesEditProfileRepository(
        factory: EditProfileDataSourceFactory,
        mapper: RegisterEntityMapper
    ): EditProfileRepository = EditProfileRepositoryImpl(factory, mapper)

}