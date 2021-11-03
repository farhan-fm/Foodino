package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import com.example.karidmarket.domain.repository.MealPlanRepository
import com.example.karidmarket.domain.repository.RecipeRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMealPlanUseCase @Inject constructor(
    private val mealPlanRepository: MealPlanRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<MealPlanResponse, GetMealPlanUseCase.Param>(threadExecutor, postExecutionThread) {

    class Param(val timeFrame: String) {
        companion object {
            fun forGetMealPlan(timeFrame: String) = Param(timeFrame)
        }
    }

    override fun buildUseCaseObservable(inputs: Param): Single<MealPlanResponse>? =
        mealPlanRepository.getMealPlane(inputs.timeFrame)
}