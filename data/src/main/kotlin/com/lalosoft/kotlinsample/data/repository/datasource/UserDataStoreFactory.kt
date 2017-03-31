package com.lalosoft.kotlinsample.data.repository.datasource

import android.content.Context
import javax.inject.Singleton
import com.lalosoft.kotlinsample.data.net.RestApiImpl
import com.lalosoft.kotlinsample.data.cache.UserCache
import com.lalosoft.kotlinsample.data.entity.mapper.UserEntityJsonMapper



/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
class UserDataStoreFactory (val context: Context, val userCache: UserCache){

    /**
     * Create [UserDataStore] from a user id.
     */
    fun create(userId: Int): UserDataStore {
        val userDataStore: UserDataStore

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = DiskUserDataStore(this.userCache)
        } else {
            userDataStore = createCloudDataStore()
        }

        return userDataStore
    }

    /**
     * Create [UserDataStore] to retrieve data from the Cloud.
     */
    fun createCloudDataStore(): UserDataStore {
        val userEntityJsonMapper = UserEntityJsonMapper()
        val restApi = RestApiImpl(this.context, userEntityJsonMapper)

        return CloudUserDataStore(restApi, this.userCache)
    }
}