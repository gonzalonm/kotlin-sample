package com.lalosoft.kotlinsample.data.repository.datasource

import com.lalosoft.kotlinsample.data.cache.UserCache
import com.lalosoft.kotlinsample.data.entity.UserEntity
import io.reactivex.Observable

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
class DiskUserDataStore (var userCache: UserCache): UserDataStore {

    override fun userEntityList(): Observable<List<UserEntity>>? {
        //TODO: implement simple cache for storing/retrieving collections of users.
        throw UnsupportedOperationException("Operation is not available!!!");
    }

    override fun userEntityDetails(userId: Int): Observable<UserEntity>? {
        return userCache[userId]
    }
}