package com.example.karidmarket.presentation.editprofile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetEditProfileUseCase
import com.example.karidmarket.presentation.editprofile.model.UserModelDataMapper
import javax.inject.Inject

class EditProfileViewModelFactory @Inject constructor(
    private val editProfileUseCase: GetEditProfileUseCase,
    private val mapper: UserModelDataMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EditProfileViewModel(
                editProfileUseCase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}