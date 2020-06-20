package ru.redmadrobot.digitalhackaton_2.login.domain

import ru.redmadrobot.digitalhackaton_2.App
import ru.redmadrobot.digitalhackaton_2.base.BasePresenter
import ru.redmadrobot.digitalhackaton_2.data.LoginRequest
import ru.redmadrobot.digitalhackaton_2.extensions.ioSubscribe
import ru.redmadrobot.digitalhackaton_2.extensions.uiObserve
import ru.redmadrobot.digitalhackaton_2.login.LoginActivity

class LoginPresenter(private val view: LoginActivity) : BasePresenter() {

    fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        App.api.login(loginRequest)
            .ioSubscribe()
            .uiObserve()
            .subscribe(view::onLoginSuccess, view::onLoginFailed)
            .autoDispose()
    }
}
