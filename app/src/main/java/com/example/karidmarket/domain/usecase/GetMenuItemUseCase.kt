package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.mealplane.MealPlanResponse
import com.example.karidmarket.domain.model.menuitem.MenuItemResponces
import com.example.karidmarket.domain.repository.MealPlanRepository
import com.example.karidmarket.domain.repository.MenuItemRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMenuItemUseCase @Inject constructor(
    private val menuItemRepository: MenuItemRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<MenuItemResponces, GetMenuItemUseCase.Param>(threadExecutor, postExecutionThread) {

    class Param(val id: Int) {
        companion object {
            fun forGetingMenuItem(id: Int) = Param(id)
        }
    }

    override fun buildUseCaseObservable(inputs: Param): Single<MenuItemResponces>? =
        menuItemRepository.getMenuItem(inputs.id)
}