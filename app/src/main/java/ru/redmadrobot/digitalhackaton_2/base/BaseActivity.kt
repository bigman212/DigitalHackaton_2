package ru.redmadrobot.digitalhackaton_2.base

import androidx.appcompat.app.AppCompatActivity
import ru.redmadrobot.digitalhackaton_2.extensions.showToast

open class BaseActivity : AppCompatActivity() {

    fun showError(err: Throwable) {
        showToast(err.message ?: "Произошла ошибка")
    }
}
