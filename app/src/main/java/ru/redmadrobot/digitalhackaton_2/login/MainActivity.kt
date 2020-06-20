package ru.redmadrobot.digitalhackaton_2.login

import android.os.Bundle
import ru.redmadrobot.digitalhackaton_2.App
import ru.redmadrobot.digitalhackaton_2.base.BaseActivity
import ru.redmadrobot.digitalhackaton_2.data.AuthToken
import ru.redmadrobot.digitalhackaton_2.databinding.ActivityMainBinding
import ru.redmadrobot.digitalhackaton_2.extensions.*
import ru.redmadrobot.digitalhackaton_2.login.domain.LoginPresenter

class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var presenter: LoginPresenter

    private var easterEgg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = LoginPresenter(this)

        binding.imgCompanyIcon.setOnClickListener {
            val neededEggs = 3
            easterEgg++
            if (easterEgg == neededEggs) {
                binding.etLoginValue.text?.clear()
                binding.etLoginValue.text?.append("admin")
                binding.etPasswordValue.text?.clear()
                binding.etPasswordValue.text?.append("admin")
                easterEgg = 0
            } else {
                showToast("До заполнения тестовыми данными осталось ${neededEggs - easterEgg} нажатия")
            }
        }

        binding.btnLogin.setOnClickListener {
            hideKeyboard(currentFocus)
            val username = binding.etLoginValue.fieldValue()
            val password = binding.etPasswordValue.fieldValue()
            presenter.login(username, password)
            binding.pbLoading.showLoading()
        }
    }

    fun onLoginSuccess(token: AuthToken) {
        App.authToken = token
        binding.pbLoading.hideLoading()
    }

    fun onLoginFailed(error: Throwable) {
        showError(error)
        binding.pbLoading.hideLoading()
    }
}
