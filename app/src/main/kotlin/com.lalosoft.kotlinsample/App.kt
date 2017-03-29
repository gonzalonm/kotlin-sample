package com.lalosoft.kotlinsample

import android.app.Application
import com.lalosoft.kotlinsample.injection.component.AppComponent

/**
 * Created by gonzalo on 3/29/17
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        setupComponent()
    }

    private fun setupComponent() {
        appComponent = DaggerAppComponent.builder().build()
    }

}