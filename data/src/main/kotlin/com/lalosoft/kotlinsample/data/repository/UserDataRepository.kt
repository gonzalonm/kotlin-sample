package com.lalosoft.kotlinsample.data.repository

import com.lalosoft.kotlinsample.domain.User
import com.lalosoft.kotlinsample.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Singleton
import com.lalosoft.kotlinsample.data.entity.mapper.UserEntityDataMapper
import com.lalosoft.kotlinsample.data.repository.datasource.UserDataStoreFactory
import javax.inject.Inject


/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
class UserDataRepository @Inject constructor(val userDataStoreFactory: UserDataStoreFactory,
                                             val userEntityDataMapper: UserEntityDataMapper): UserRepository {

    override fun users(): Observable<List<User>>? {
        //we always get all users from the cloud
        val userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList()?.map(this.userEntityDataMapper::transform);
    }

    override fun user(userId: Int): Observable<User>? {
        val userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId)?.map(this.userEntityDataMapper::transform)
    }
}