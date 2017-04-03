package com.lalosoft.kotlinsample.ui.basic

import android.content.Context

/**
 * Created by gonzalo on 3/29/17
 */

abstract class BasePresenter constructor(val view : BaseView) {

    open fun onCreate(context: Context) {
        // to be implemented by sub-classes
    }

    open fun onStart() {
        // to be implemented by sub-classes
    }

    open fun onResume() {
        // to be implemented by sub-classes
    }

    open fun onPause() {
        // to be implemented by sub-classes
    }

    open fun onStop() {
        // to be implemented by sub-classes
    }

}