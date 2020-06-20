package ru.redmadrobot.digitalhackaton_2.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import ru.redmadrobot.digitalhackaton_2.databinding.ActivityMainBinding
import ru.redmadrobot.digitalhackaton_2.extensions.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    private var easterEgg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
            Completable.fromAction { binding.pbLoading.showLoading() }
                .delay(5, TimeUnit.SECONDS)
                .uiObserve()
                .subscribe {
                    binding.pbLoading.hideLoading()
                }
        }
    }
}
