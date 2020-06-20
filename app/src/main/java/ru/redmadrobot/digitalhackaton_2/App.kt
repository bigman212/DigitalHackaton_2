package ru.redmadrobot.digitalhackaton_2

import android.app.Application
import ru.redmadrobot.digitalhackaton_2.data.ApiClient
import ru.redmadrobot.digitalhackaton_2.data.ApiService
import ru.redmadrobot.digitalhackaton_2.data.AuthToken

class App : Application() {

    companion object {
        lateinit var api: ApiService
        var authToken: AuthToken? = null
    }

    override fun onCreate() {
        super.onCreate()
        api = ApiClient.createService()
    }
}
