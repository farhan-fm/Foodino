package com.example.karidmarket.presentation.generatemeal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetMealPlanUseCase
import com.example.karidmarket.presentation.generatemeal.model.MealPlanModelDataMapper
import com.example.karidmarket.presentation.generatemeal.model.MealPlanResponseModel
import com.example.karidmarket.presentation.recipes.model.RecipedModel
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class GenerateMealViewModel constructor(
    private var mapper: MealPlanModelDataMapper,
    private var useCase: GetMealPlanUseCase
) : ViewModel() {

    var mealPlanLiveData = MutableLiveData<Result>()
    private var disposable = CompositeDisposable()
    private lateinit var result: Result

    fun getMealPlan(timeFrame: String) {

        result = Result(null, State.LOADING_DATA, null)
        mealPlanLiveData.value = result

        val param = GetMealPlanUseCase.Param.forGetMealPlan(timeFrame)
        val d: Disposable? = useCase.execute(param)?.subscribe({ data ->
            result = Result(mapper.transform(data), State.DATA_LOADED, null)
            mealPlanLiveData.value = result
        }, {
            result = Result(null, State.LOAD_ERROR, null)
            mealPlanLiveData.value = result
        })
        d?.let { disposable.add(it) }
    }

    data class Result(
        val response: MealPlanResponseModel?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        LOAD_ERROR
    }

}