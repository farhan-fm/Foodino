package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.RegisterRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetRegisterUseCase @Inject constructor(
    private val registerRepository: RegisterRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Long, GetRegisterUseCase.Params>(threadExecutor, postExecutionThread) {

    class Params(val user: User) {
        companion object {
            fun getRegisterUser(user: User) = Params(user)
        }
    }

    override fun buildUseCaseObservable(inputs: Params): Single<Long>? =
        registerRepository.registerUser(inputs.user)

}