package com.lalosoft.kotlinsample.domain.interactor

import com.lalosoft.kotlinsample.domain.User
import io.reactivex.Observable
import com.lalosoft.kotlinsample.domain.repository.UserRepository
import com.lalosoft.kotlinsample.domain.executor.PostExecutionThread
import com.lalosoft.kotlinsample.domain.executor.ThreadExecutor
import javax.inject.Inject

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
class GetUserList @Inject constructor(val userRepository: UserRepository, var threadExecutor: ThreadExecutor,
                                      var postExecutionThread: PostExecutionThread) : UseCase<List<User>, Void>() {

    override fun buildUseCaseObservable(params: Void): Observable<List<User>>? {
        return this.userRepository.users()
    }
}