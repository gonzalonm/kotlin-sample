package com.lalosoft.kotlinsample.data

import com.lalosoft.kotlinsample.data.model.User
import io.reactivex.Observable

/**
 * Created by gonzalo on 3/29/17
 */

interface DataManager {

    fun getUser(id: Int): Observable<User>

}
