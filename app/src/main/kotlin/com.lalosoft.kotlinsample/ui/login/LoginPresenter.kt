package com.lalosoft.kotlinsample.ui.login

import android.content.Context
import com.lalosoft.kotlinsample.ui.basic.BasePresenter

/**
 * Created by gonzalo on 4/3/17
 */
class LoginPresenter(view: LoginView) : BasePresenter(view) {

    lateinit var context: Context


    override fun onCreate(ctx: Context) {
        super.onCreate(ctx)
        context = ctx
    }

    fun onLoginClick(email: String) {
        if (email.isEmpty()) {
            (view as LoginView).showEmptyEmailError()
        } else {
            (view as LoginView).showLoginSuccess()
        }
    }
}