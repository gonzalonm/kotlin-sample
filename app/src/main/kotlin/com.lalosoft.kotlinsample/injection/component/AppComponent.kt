package com.lalosoft.kotlinsample.injection.component

import com.lalosoft.kotlinsample.injection.module.Bindings
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gonzalo on 3/29/17
 */

@Singleton
@Component(modules = arrayOf(Bindings::class))
interface AppComponent {

    fun activityComponent(): ActivityComponent

}