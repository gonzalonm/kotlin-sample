package com.lalosoft.kotlinsample.data.entity.mapper

import com.google.gson.Gson
import javax.inject.Inject
import com.lalosoft.kotlinsample.data.entity.UserEntity
import com.google.gson.reflect.TypeToken
import com.google.gson.JsonSyntaxException



/**
 * Class used to transform from Strings representing json to valid objects.
 */
class UserEntityJsonMapper @Inject constructor() {

    val gson: Gson = Gson()

    /**
     * Transform from valid json string to [UserEntity].

     * @param userJsonResponse A json representing a user profile.
     * *
     * @return [UserEntity].
     * *
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    @Throws(JsonSyntaxException::class)
    fun transformUserEntity(userJsonResponse: String): UserEntity {
        val userEntityType = object : TypeToken<UserEntity>() {}.type
        return this.gson.fromJson(userJsonResponse, userEntityType)
    }

    /**
     * Transform from valid json string to List of [UserEntity].

     * @param userListJsonResponse A json representing a collection of users.
     * *
     * @return List of [UserEntity].
     * *
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    @Throws(JsonSyntaxException::class)
    fun transformUserEntityCollection(userListJsonResponse: String): List<UserEntity> {
        val listOfUserEntityType = object : TypeToken<List<UserEntity>>() {}.type
        return this.gson.fromJson(userListJsonResponse, listOfUserEntityType)
    }
}