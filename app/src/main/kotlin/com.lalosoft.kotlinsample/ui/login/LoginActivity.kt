package com.lalosoft.kotlinsample.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.lalosoft.kotlinsample.R
import com.lalosoft.kotlinsample.ui.basic.BaseActivity
import com.lalosoft.kotlinsample.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun buildPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun getResLayout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        login_button.setOnClickListener({
            presenter.onLoginClick(email.text.toString())
        })
    }

    override fun showEmptyEmailError() {
        Toast.makeText(this, getString(R.string.error_login_empty), Toast.LENGTH_SHORT).show()
    }

    override fun showLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
