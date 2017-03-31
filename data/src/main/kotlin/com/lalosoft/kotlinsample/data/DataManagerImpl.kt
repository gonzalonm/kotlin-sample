package com.lalosoft.kotlinsample.data

import com.lalosoft.kotlinsample.data.remote.UserService
import com.lalosoft.kotlinsample.domain.User
import io.reactivex.Observable

/**
 * Created by gonzalo on 3/29/17
 */

internal class DataManagerImpl constructor(val userService: com.lalosoft.kotlinsample.data.remote.UserService): DataManager {

    override fun getUser(id: Int): Observable<User> {
        return userService.fetchUser(id).flatMap { Observable.just(it.value) }
    }

}