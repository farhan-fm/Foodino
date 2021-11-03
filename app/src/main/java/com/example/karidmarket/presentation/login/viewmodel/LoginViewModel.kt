package com.example.karidmarket.presentation.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetUserLoginUseCase
import com.example.karidmarket.domain.usecase.type.UseCase
import com.example.karidmarket.presentation.login.model.UserModel
import com.example.karidmarket.presentation.login.model.UserModelMapper
import com.example.karidmarket.presentation.recipes.model.RecipedModel
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class LoginViewModel constructor(
    private val loginUseCase: GetUserLoginUseCase,
    private val mapper: UserModelMapper
) : ViewModel() {

    val loginUserLiveData = MutableLiveData<Result>()
    private val disposable = CompositeDisposable()
    private lateinit var result: Result


    fun getLogin(email: String, password: String) {
        result = Result(null, State.LOADING_DATA, null)
        loginUserLiveData.value = result

        val param = GetUserLoginUseCase.Params.forGetLogin(email, password)
        val d: Disposable? = loginUseCase.execute(param)?.subscribe({ user ->
            result = Result(mapper.transformer(user), State.DATA_LOADED, null)
            loginUserLiveData.value = result
        }, {
            result = Result(null, State.LOAD_ERROR, it.message)
            loginUserLiveData.value = result
        })
        d?.let { disposable.add(it) }

    }


    data class Result(
        val response: UserModel?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        LOAD_ERROR
    }

}