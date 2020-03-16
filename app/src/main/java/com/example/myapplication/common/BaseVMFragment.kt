package com.example.myapplication.common

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseVMFragment<out T : BaseViewModel> : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModel: T?


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initObservers()
//        viewModel?.appRouter = appRouter
//    }

    protected inline fun <reified VM : ViewModel> injectViewModel(): Lazy<VM> =
        activityViewModels { viewModelFactory }

}