package ru.redmadrobot.digitalhackaton_2.ideas.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.redmadrobot.digitalhackaton_2.App
import ru.redmadrobot.digitalhackaton_2.base.BaseActivity
import ru.redmadrobot.digitalhackaton_2.data.ResponseWithResult
import ru.redmadrobot.digitalhackaton_2.databinding.ActivityIdeaListBinding
import ru.redmadrobot.digitalhackaton_2.extensions.ioSubscribe
import ru.redmadrobot.digitalhackaton_2.extensions.uiObserve
import ru.redmadrobot.digitalhackaton_2.extensions.viewBinding
import ru.redmadrobot.digitalhackaton_2.ideas.list.data.IdeaOffer
import timber.log.Timber

class IdeaListActivity : BaseActivity() {

    companion object {
        fun createStarter(from: Context): Intent = Intent(from, IdeaListActivity::class.java)
    }

    private val binding: ActivityIdeaListBinding by viewBinding(ActivityIdeaListBinding::inflate)

    val dataAdapter: IdeaListAdapter = IdeaListAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvIdeas.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = dataAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        val subscribe = App.api.allIdeas()
            .ioSubscribe()
            .uiObserve()
            .map(ResponseWithResult<IdeaOffer>::results)
            .subscribe(
                {
                    dataAdapter.updateList(it)
                },
                {
                    showError(it)
                    Timber.e(it)
                }
            )
    }
}
