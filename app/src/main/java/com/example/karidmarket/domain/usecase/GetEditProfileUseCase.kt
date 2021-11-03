package com.example.karidmarket.domain.usecase

import com.example.karidmarket.domain.executor.PostExecutionThread
import com.example.karidmarket.domain.executor.ThreadExecutor
import com.example.karidmarket.domain.model.User
import com.example.karidmarket.domain.repository.EditProfileRepository
import com.example.karidmarket.domain.usecase.type.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetEditProfileUseCase @Inject constructor(
    private val editProfileRepository: EditProfileRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Int, GetEditProfileUseCase.Params>(threadExecutor, postExecutionThread) {

    class Params(val user: User) {
        companion object {
            fun forEditProfile(user: User) = Params(user)
        }

    }

    override fun buildUseCaseObservable(inputs: Params): Single<Int>? =
        editProfileRepository.editUser(inputs.user)

}