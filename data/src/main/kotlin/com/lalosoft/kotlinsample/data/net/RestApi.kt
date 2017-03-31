package com.lalosoft.kotlinsample.data.net

import com.lalosoft.kotlinsample.data.entity.UserEntity
import io.reactivex.Observable


/**
 * RestApi for retrieving data from the network.
 */
interface RestApi {

    /**
     * Retrieves an [Observable] which will emit a List of [UserEntity].
     */
    fun userEntityList(): Observable<List<UserEntity>>

    /**
     * Retrieves an [Observable] which will emit a [UserEntity].

     * @param userId The user id used to get user data.
     */
    fun userEntityById(userId: Int): Observable<UserEntity>

}