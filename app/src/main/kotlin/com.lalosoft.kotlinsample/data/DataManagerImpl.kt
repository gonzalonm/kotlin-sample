package com.lalosoft.kotlinsample.data

import com.lalosoft.kotlinsample.data.model.User
import com.lalosoft.kotlinsample.data.remote.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by gonzalo on 3/29/17
 */

internal class DataManagerImpl @Inject constructor(val userService: UserService): DataManager {

    override fun getUser(id: Int): Observable<User> {
        return userService.fetchUser(id).flatMap { Observable.just(it.value) }
    }

}