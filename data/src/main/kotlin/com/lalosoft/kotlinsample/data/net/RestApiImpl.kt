package com.lalosoft.kotlinsample.data.net

import android.content.Context
import com.lalosoft.kotlinsample.data.entity.UserEntity
import com.lalosoft.kotlinsample.data.entity.mapper.UserEntityJsonMapper
import io.reactivex.Observable

/**
* {@link RestApi} implementation for retrieving data from the network.
*/
class RestApiImpl : RestApi {

    var API_BASE_URL = "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/"

    /** Api url for getting all users  */
    var API_URL_GET_USER_LIST = API_BASE_URL + "users.json"
    /** Api url for getting a user profile: Remember to concatenate id + 'json'  */
    var API_URL_GET_USER_DETAILS = API_BASE_URL + "user_"

    var context: Context
    var userEntityJsonMapper: UserEntityJsonMapper? = null

    constructor(ctx: Context, userEntityJsonMapper: UserEntityJsonMapper) {
        if (userEntityJsonMapper == null) {
            throw IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        context = ctx.getApplicationContext()
        this.userEntityJsonMapper = userEntityJsonMapper
    }

    override fun userEntityById(userId: Int): Observable<UserEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userEntityList(): Observable<List<UserEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}