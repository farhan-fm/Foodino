package com.example.karidmarket.presentation.signup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetRegisterUseCase
import com.example.karidmarket.presentation.signup.model.UserModel
import com.example.karidmarket.presentation.signup.model.UserModelDataMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class RegisterViewModel constructor(
    private val registerUseCase: GetRegisterUseCase,
    private val mapper: UserModelDataMapper
) : ViewModel() {

    var registerLiveData = MutableLiveData<Result>()
    private var disposable = CompositeDisposable()
    private lateinit var result: Result

    fun getRegistering(userModel: UserModel) {
        result = Result(null, State.LOADING_DATA, null)
        registerLiveData.value = result

        val param =
            GetRegisterUseCase.Params.getRegisterUser(mapper.transformUserModelToUser(userModel))
        val d: Disposable? = registerUseCase.execute(param)?.subscribe({ res ->
            result = Result(res, State.DATA_LOADED, null)
            registerLiveData.value = result
        }, {
            result = Result(null, State.LOAD_ERROR, null)
            registerLiveData.value = result
        })
        d?.let { disposable.add(it) }
    }

    data class Result(
        var response: Long?,
        var state: State?,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        LOAD_ERROR
    }

}