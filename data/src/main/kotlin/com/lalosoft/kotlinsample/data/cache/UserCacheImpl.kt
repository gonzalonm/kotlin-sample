package com.lalosoft.kotlinsample.data.cache

import com.lalosoft.kotlinsample.data.entity.UserEntity
import io.reactivex.Observable


/**
 * {@link UserCache} implementation.
 */
class UserCacheImpl : UserCache {

    override fun get(userId: Int): Observable<UserEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(userEntity: UserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(userId: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun evictAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}