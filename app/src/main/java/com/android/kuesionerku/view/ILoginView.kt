package com.android.kuesionerku.view

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}