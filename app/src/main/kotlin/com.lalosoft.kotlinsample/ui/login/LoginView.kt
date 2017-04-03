package com.lalosoft.kotlinsample.ui.login

import com.lalosoft.kotlinsample.ui.basic.BaseView

/**
 * Created by gonzalo on 4/3/17
 */
interface LoginView : BaseView {

    fun showEmptyEmailError()
    fun showLoginSuccess()
}