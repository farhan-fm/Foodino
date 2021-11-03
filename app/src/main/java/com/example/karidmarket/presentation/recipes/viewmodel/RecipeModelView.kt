package com.example.karidmarket.presentation.recipes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetRecipeInformation
import com.example.karidmarket.presentation.recipes.model.RecipeModelDataMapper
import com.example.karidmarket.presentation.recipes.model.RecipedModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class RecipeModelView constructor(
    private val useCase: GetRecipeInformation,
    private val mapper: RecipeModelDataMapper
) : ViewModel() {

    val recipeLiveData = MutableLiveData<Result>()
    private val disposables = CompositeDisposable()
    private lateinit var result: Result
    private var currentPage: Int = 1

    fun getRecipe() {
        result = Result(null, State.DATA_LOADED, null)
        recipeLiveData.value = result

        val param = GetRecipeInformation.Param.forGetRecipe(currentPage++)
        val d: Disposable? = useCase.execute(param)?.subscribe(
            { data ->
                result = Result(mapper.transformRecipe(data), State.DATA_LOADED, null)
                recipeLiveData.value = result

            }, {
                result = Result(null, State.LOAD_ERROR, it.message)
                recipeLiveData.value = result
            }
        )
        d?.let { disposables.add(it) }

    }

    fun loadMoreRecipe(){
        if (currentIdLimitation()){
            result = Result(null, State.DATA_LOADED, null)
            recipeLiveData.value = result

            val param = GetRecipeInformation.Param.forGetRecipe(currentPage++)
            val d: Disposable? = useCase.execute(param)?.subscribe(
                { data ->
                    result = Result(mapper.transformRecipe(data), State.MORE_DATA_LOADED, null)
                    recipeLiveData.value = result

                }, {
                    result = Result(null, State.LOAD_MORE_ERROR, it.message)
                    recipeLiveData.value = result
                }
            )
            d?.let { disposables.add(it) }
        }
    }

    private fun currentIdLimitation() :Boolean=
        currentPage<=100


    data class Result(
        val response: RecipedModel?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        MORE_DATA_LOADED,
        LOAD_ERROR,
        LOAD_MORE_ERROR
    }

}