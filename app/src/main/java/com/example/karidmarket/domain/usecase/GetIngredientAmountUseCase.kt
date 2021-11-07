package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.ingredientamount.IngredientAmountResponse
import com.example.karidmarket.domain.repository.IngredientAmountRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetIngredientAmountUseCase @Inject constructor(
    private val ingredientAmountRepository: IngredientAmountRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<IngredientAmountResponse, GetIngredientAmountUseCase.Param>(
    threadExecutor,
    postExecutionThread
) {

    class Param(val id: Int, val amount: Int) {
        companion object {
            fun forGetIngredientAmount(id: Int, amount: Int) = Param(id, amount)
        }
    }

    override fun buildUseCaseObservable(inputs: Param): Single<IngredientAmountResponse>? =
        ingredientAmountRepository.getIngredientAmount(inputs.id, inputs.amount)


}