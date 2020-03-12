package com.example.myapplication.common

import io.reactivex.CompletableTransformer
import io.reactivex.ObservableTransformer

interface DataManagerInterface {

    fun <T> async(): ObservableTransformer<T, T>?

    fun <T> io(): ObservableTransformer<T, T>?

    fun cAsync(): CompletableTransformer?

    fun cIo(): CompletableTransformer?

    fun <T> main(): ObservableTransformer<T, T>?
}