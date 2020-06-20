package ru.redmadrobot.digitalhackaton_2.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter {
    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.autoDispose() {
        compositeDisposable.add(this)
    }
}
