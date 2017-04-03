package com.lalosoft.kotlinsample.ui.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by gonzalo on 3/29/17
 */

abstract class BaseActivity<T: BasePresenter> : AppCompatActivity() {

    lateinit var presenter: T

    abstract fun  buildPresenter(): T

    abstract fun getResLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResLayout())
        presenter = buildPresenter()
        presenter.onCreate(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}