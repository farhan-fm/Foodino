package com.example.karidmarket.presentation.app

import android.content.Context
import com.example.karidmarket.data.executor.JobExecutor
import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.UiThread
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    internal fun provideContext() = context

    @Provides
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread

}
