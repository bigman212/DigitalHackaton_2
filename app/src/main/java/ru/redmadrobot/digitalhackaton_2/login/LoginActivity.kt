package ru.redmadrobot.digitalhackaton_2.login

import android.os.Bundle
import ru.redmadrobot.digitalhackaton_2.App
import ru.redmadrobot.digitalhackaton_2.base.BaseActivity
import ru.redmadrobot.digitalhackaton_2.data.AuthToken
import ru.redmadrobot.digitalhackaton_2.databinding.ActivityLoginBinding
import ru.redmadrobot.digitalhackaton_2.extensions.*
import ru.redmadrobot.digitalhackaton_2.ideas.list.IdeaListActivity
import ru.redmadrobot.digitalhackaton_2.login.domain.LoginPresenter

class LoginActivity : BaseActivity() {
    private val binding: ActivityLoginBinding by viewBinding(ActivityLoginBinding::inflate)
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
            val usernameEntered = binding.etLoginValue.fieldValue().isNotBlank()
            val passwordEntered = binding.etPasswordValue.fieldValue().isNotBlank()
            if (usernameEntered and passwordEntered) {
                hideKeyboard(currentFocus)

                val username = binding.etLoginValue.fieldValue()
                val password = binding.etPasswordValue.fieldValue()
                presenter.login(username, password)
                binding.pbLoading.showLoading()
            }
            binding.tlLogin.error = if (usernameEntered) null else "Заполните поле"
            binding.tlPassword.error = if (passwordEntered) null else "Заполните поле пароля"
        }
    }

    fun onLoginSuccess(token: AuthToken) {
        App.authToken = token
        binding.pbLoading.hideLoading()

        startActivity(IdeaListActivity.createStarter(this))
    }

    fun onLoginFailed(error: Throwable) {
        showError(error)
        binding.pbLoading.hideLoading()
    }
}
