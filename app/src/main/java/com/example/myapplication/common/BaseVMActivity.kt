package com.example.myapplication.common

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseVMActivity<out T : BaseViewModel> : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModel: T?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected inline fun <reified VM : ViewModel> injectViewModel(): Lazy<VM> =
        viewModels { viewModelFactory }

}