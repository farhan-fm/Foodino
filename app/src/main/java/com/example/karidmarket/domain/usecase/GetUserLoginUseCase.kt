package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.LoginRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetUserLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<User, GetUserLoginUseCase.Params>(threadExecutor, postExecutionThread) {

    class Params(val email: String, val password: String) {
        companion object {
            fun forGetLogin(email: String, password: String) = Params(email, password)
        }
    }

    override fun buildUseCaseObservable(inputs: Params): Single<User>? =
        loginRepository.getLogin(inputs.email, inputs.password)


}