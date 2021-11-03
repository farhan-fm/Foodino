package com.example.karidmarket.presentation.editprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetEditProfileUseCase
import com.example.karidmarket.presentation.editprofile.model.UserModel
import com.example.karidmarket.presentation.editprofile.model.UserModelDataMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class EditProfileViewModel constructor(
    private val editProfileUseCase: GetEditProfileUseCase,
    private val mapper: UserModelDataMapper
) : ViewModel() {

    val editProfileLiveData = MutableLiveData<Result>()
    private var result: Result? = null
    private val disposable = CompositeDisposable()

    fun getEditProfile(userModel: UserModel) {

        result = Result(null, State.LOADING_DATA, null)
        editProfileLiveData.value = result

        val param =
            GetEditProfileUseCase.Params.forEditProfile(mapper.transformUserModelToUser(userModel))
        val d: Disposable? = editProfileUseCase.execute(param)?.subscribe({
            result = Result(it, State.DATA_LOADED, null)
            editProfileLiveData.value = result
        }, {
            result = Result(null, State.LOAD_ERROR, null)
            editProfileLiveData.value = result
        })

        d?.let { disposable.add(it) }

    }


    data class Result(
        val response: Int?,
        val state: State?,
        val error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        LOAD_ERROR
    }
}