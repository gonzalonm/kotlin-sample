package com.lalosoft.kotlinsample.data.remote

import com.lalosoft.kotlinsample.data.model.Response
import com.lalosoft.kotlinsample.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by gonzalo on 3/29/17
 */

interface UserService {

    @GET("/user/{user}")
    fun fetchUser(@Path("user") user: Int): Observable<Response<User>>

}
