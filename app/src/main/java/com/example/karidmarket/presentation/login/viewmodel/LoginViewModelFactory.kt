package com.example.karidmarket.presentation.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karidmarket.domain.usecase.GetUserLoginUseCase
import com.example.karidmarket.presentation.login.model.UserModelMapper
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    private val loginUseCase: GetUserLoginUseCase,
    private val mapper: UserModelMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(
                loginUseCase,
                mapper
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}