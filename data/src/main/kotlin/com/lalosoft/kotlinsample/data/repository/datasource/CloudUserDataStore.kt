package com.lalosoft.kotlinsample.data.repository.datasource

import com.lalosoft.kotlinsample.data.entity.UserEntity
import io.reactivex.Observable
import com.lalosoft.kotlinsample.data.net.RestApi
import com.lalosoft.kotlinsample.data.cache.UserCache


/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore(val restApi: RestApi, val userCache: UserCache) : UserDataStore {

    override fun userEntityList(): Observable<List<UserEntity>>? {
        return this.restApi.userEntityList()
    }

    override fun userEntityDetails(userId: Int): Observable<UserEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}