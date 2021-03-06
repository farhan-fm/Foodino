package com.example.karidmarket.domain.usecase.type

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class UseCase<Outputs, Inputs>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract fun buildUseCaseObservable(inputs: Inputs): Single<Outputs>?

    fun execute(inputs: Inputs): Single<Outputs>? =
        buildUseCaseObservable(inputs)
            ?.subscribeOn(Schedulers.from(threadExecutor))
            ?.observeOn(postExecutionThread.getScheduler())

}