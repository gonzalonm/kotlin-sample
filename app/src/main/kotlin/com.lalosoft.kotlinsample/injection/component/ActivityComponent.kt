package com.lalosoft.kotlinsample.injection.component

import com.lalosoft.kotlinsample.injection.scope.PerActivity
import com.lalosoft.kotlinsample.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by gonzalo on 3/29/17
 */

@PerActivity
@Subcomponent
interface ActivityComponent {

    fun inject(activity: MainActivity)

}
