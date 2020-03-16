package com.example.myapplication.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dagger.qualifier.ViewModelKey
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.ui.TextViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TextViewModel::class)
    abstract fun bindTextViewModel(textViewModel: TextViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}