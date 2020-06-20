package ru.redmadrobot.digitalhackaton_2.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.uiObserve(): Single<T> {
    return observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.ioSubscribe(): Single<T> {
    return subscribeOn(Schedulers.io())
}

fun <T> Observable<T>.uiObserve(): Observable<T> {
    return observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.ioSubscribe(): Observable<T> {
    return subscribeOn(Schedulers.io())
}

fun Completable.uiObserve(): Completable {
    return observeOn(AndroidSchedulers.mainThread())
}

fun Completable.ioSubscribe(): Completable {
    return subscribeOn(Schedulers.io())
}
