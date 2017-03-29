package com.lalosoft.kotlinsample.injection.scope

import javax.inject.Scope

/**
 * Created by gonzalo on 3/29/17
 */

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity
