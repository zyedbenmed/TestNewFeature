package com.example.myapplication.common

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

open class BaseViewModel: ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val errorEvent: MutableLiveData<String> = MutableLiveData()

    init {
        toggleLoading(false)
    }

    private val busEventSubscriptions: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private val subscriptions: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun toggleLoading(isLoading: Boolean) {
        loading.postValue(isLoading)
    }

    private fun sub(s: Disposable) {
        this.subscriptions.add(s)
    }


    private fun clearSubs() {
        this.subscriptions.clear()
    }

    protected open fun <R> subscribe(
        observable: Observable<R>,
        onNext: Consumer<in R>?,
        onError: Consumer<in Throwable>?,
        onCompleted: Action?
    ) {
        this.sub(observable.subscribe(onNext, onError, onCompleted))
    }

    protected fun <R> subscribe(
        observable: Observable<R>,
        onNext: Consumer<in R>?,
        onError: Consumer<in Throwable>?
    ) {
        this.subscribe(observable, onNext, onError, Action {})
    }

    protected open fun <R> subscribe(
        observable: Observable<R>,
        onNext: Consumer<in R>?
    ) {
        this.subscribe(
            observable,
            onNext,
            null
        )
    }

    @SuppressLint("CheckResult")
    protected open fun subscribe(
        completable: Completable,
        onComplete: Action?,
        onError: Consumer<in Throwable>?
    ) {
        completable.doOnSubscribe { s: Disposable ->
            this.sub(
                s
            )
        }.subscribe(onComplete, onError)
    }

    protected open fun subscribe(
        completable: Completable,
        onComplete: Action?
    ) {
        this.subscribe(
            completable,
            onComplete,
            null
        )
    }

}