package ru.redmadrobot.digitalhackaton_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Completable
import ru.redmadrobot.digitalhackaton_2.databinding.ActivityMainBinding
import ru.redmadrobot.digitalhackaton_2.extensions.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
