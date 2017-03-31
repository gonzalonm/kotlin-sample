package com.lalosoft.kotlinsample.domain.repository

import com.lalosoft.kotlinsample.domain.User
import io.reactivex.Observable

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
interface UserRepository {

    /**
     * Get an [Observable] which will emit a List of [User].
     */
    fun users(): Observable<List<User>>?

    /**
     * Get an [Observable] which will emit a [User].

     * @param userId The user id used to retrieve user data.
     */
    fun user(userId: Int): Observable<User>?
}