package com.android.kuesionerku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.kuesionerku.R
import com.android.kuesionerku.presenter.ILoginPresenter
import com.android.kuesionerku.presenter.LoginPresenter
import com.android.kuesionerku.view.ILoginView
import es.dmoral.toasty.Toasty
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity(), ILoginView {

    override fun onLoginSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, NavActivity::class.java).apply {

        }
        startActivity(intent)
    }

    override fun onLoginError(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    internal lateinit var loginPresenter: ILoginPresenter
    private lateinit var btn_login: Button
    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login = findViewById(R.id.btn_login)
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)

        loginPresenter = LoginPresenter(this)

        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }

    }

}