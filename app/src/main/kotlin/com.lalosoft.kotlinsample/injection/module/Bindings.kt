package com.lalosoft.kotlinsample.injection.module

import com.lalosoft.kotlinsample.data.DataManager
import com.lalosoft.kotlinsample.data.DataManagerImpl
import dagger.Binds
import dagger.Module

/**
 * Created by gonzalo on 3/29/17
 */

@Module
abstract class Bindings {

    @Binds
    internal abstract fun bindDataManger(manager: DataManagerImpl): DataManager

}
