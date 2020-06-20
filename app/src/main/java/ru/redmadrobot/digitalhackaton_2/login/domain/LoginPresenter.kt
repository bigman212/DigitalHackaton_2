package ru.redmadrobot.digitalhackaton_2.login.domain

import ru.redmadrobot.digitalhackaton_2.App
import ru.redmadrobot.digitalhackaton_2.base.BasePresenter
import ru.redmadrobot.digitalhackaton_2.data.LoginRequest
import ru.redmadrobot.digitalhackaton_2.extensions.ioSubscribe
import ru.redmadrobot.digitalhackaton_2.extensions.uiObserve
import ru.redmadrobot.digitalhackaton_2.login.MainActivity

class LoginPresenter(private val view: MainActivity) : BasePresenter() {
    private val apiClient = App.api

    fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        apiClient.login(loginRequest)
            .ioSubscribe()
            .uiObserve()
            .subscribe(view::onLoginSuccess, view::onLoginFailed)
            .autoDispose()
    }
}
