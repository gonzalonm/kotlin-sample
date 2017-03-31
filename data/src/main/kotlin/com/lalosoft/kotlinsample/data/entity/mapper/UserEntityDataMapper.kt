package com.lalosoft.kotlinsample.data.entity.mapper

import javax.inject.Singleton
import javax.inject.Inject
import com.lalosoft.kotlinsample.data.entity.UserEntity
import com.lalosoft.kotlinsample.domain.User




/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
class UserEntityDataMapper @Inject constructor() {

    /**
     * Transform a [UserEntity] into an [User].

     * @param userEntity Object to be transformed.
     * *
     * @return [User] if valid [UserEntity] otherwise null.
     */
    fun transform(userEntity: UserEntity?): User? {
        var user: User? = null
        if (userEntity != null) {
            user = User(userEntity.username, userEntity.password)
        }
        return user
    }

    /**
     * Transform a List of [UserEntity] into a Collection of [User].

     * @param userEntityCollection Object Collection to be transformed.
     * *
     * @return [User] if valid [UserEntity] otherwise null.
     */
    fun transform(userEntityCollection: Collection<UserEntity>): List<User>? {
        val userList = mutableListOf<User>()
        for (userEntity in userEntityCollection) {
            val user = transform(userEntity)
            if (user != null) {
                userList.add(user)
            }
        }
        return userList
    }
}