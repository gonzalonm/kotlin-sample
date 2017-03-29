package com.lalosoft.kotlinsample.ui.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by gonzalo on 3/29/17
 */

abstract class BaseActivity<T> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}