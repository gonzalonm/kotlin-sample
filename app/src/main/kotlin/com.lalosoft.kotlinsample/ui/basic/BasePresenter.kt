package com.lalosoft.kotlinsample.ui.basic

/**
 * Created by gonzalo on 3/29/17.
 */

abstract class BasePresenter constructor(val view : BaseView) {

    fun onCreate() {
        // to override in the subclasses
    }

}