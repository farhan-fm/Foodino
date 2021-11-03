package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.recipeinformation.Reciped
import com.example.karidmarket.domain.repository.RecipeRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetRecipeInformation @Inject constructor(
    private val recipeRepository: RecipeRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Reciped, GetRecipeInformation.Param>(threadExecutor, postExecutionThread) {
    class Param(val id: Int) {
        companion object {
            fun forGetRecipe(page: Int) = Param(page)
        }
    }

    override fun buildUseCaseObservable(inputs: Param): Single<Reciped>? =
        recipeRepository.getRecipe(inputs.id)

}