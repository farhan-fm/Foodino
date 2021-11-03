package com.example.karidmarket.presentation.generatemeal.di

import com.example.karidmarket.data.mapper.MealPlanEntityMapper
import com.example.karidmarket.data.repository.datasource.mealplan.MealPlanDataSourceFactory
import com.example.karidmarket.data.repository.impl.MealPlanRepositoryImpl
import com.example.karidmarket.domain.repository.MealPlanRepository
import com.example.karidmarket.domain.usecase.GetMealPlanUseCase
import com.example.karidmarket.presentation.generatemeal.model.MealPlanModelDataMapper
import com.example.karidmarket.presentation.generatemeal.viewmodel.GenerateMealViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GenerateMealBuildModule {

    @Provides
    fun providesGenerateMealViewModelFactory(
        mapper: MealPlanModelDataMapper,
        useCase: GetMealPlanUseCase
    ) = GenerateMealViewModelFactory(mapper, useCase)

    @Provides
    fun providesMealPlanRepositoryImpl(
        factory: MealPlanDataSourceFactory,
        mapper: MealPlanEntityMapper
    ): MealPlanRepository = MealPlanRepositoryImpl(factory, mapper)

}