package com.example.karidmarket.presentation.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetRegisterUseCase
import com.example.karidmarket.presentation.login.viewmodel.LoginViewModel
import com.example.karidmarket.presentation.signup.model.UserModelDataMapper
import javax.inject.Inject

class RegisterViewModelFactory @Inject constructor(
    private val registerUseCase: GetRegisterUseCase,
    private val mapper: UserModelDataMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(
                registerUseCase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}