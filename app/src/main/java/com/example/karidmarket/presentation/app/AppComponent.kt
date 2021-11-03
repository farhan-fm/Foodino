package com.example.karidmarket.presentation.app

import android.content.Context
import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {

    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread
}