package com.example.myapplication.common

import io.reactivex.Completable
import io.reactivex.CompletableTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseDataManager: DataManagerInterface {

    override fun <T> async(): ObservableTransformer<T, T>? {
        return ObservableTransformer { o: Observable<T> ->
            o.subscribeOn(
                Schedulers.newThread()
            ).observeOn(AndroidSchedulers.mainThread())
        }
    }

    override fun <T> io(): ObservableTransformer<T, T>? {
        return ObservableTransformer { o: Observable<T> ->
            o.subscribeOn(
                Schedulers.io()
            ).observeOn(AndroidSchedulers.mainThread())
        }
    }

    override fun cAsync(): CompletableTransformer? {
        return CompletableTransformer { o: Completable ->
            o.subscribeOn(
                Schedulers.newThread()
            ).observeOn(AndroidSchedulers.mainThread())
        }
    }

    override fun cIo(): CompletableTransformer? {
        return CompletableTransformer { o: Completable ->
            o.subscribeOn(
                Schedulers.io()
            ).observeOn(AndroidSchedulers.mainThread())
        }
    }

    override fun <T> main(): ObservableTransformer<T, T>? {
        return ObservableTransformer { o: Observable<T> ->
            o.observeOn(
                AndroidSchedulers.mainThread()
            )
        }
    }
}