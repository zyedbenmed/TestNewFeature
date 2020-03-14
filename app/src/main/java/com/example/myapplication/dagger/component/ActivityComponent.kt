package com.example.myapplication.dagger.component

import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dagger.module.PostModule
import com.example.myapplication.dagger.module.ViewModelModule
import com.example.myapplication.dagger.qualifier.PostScope
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepositoryImpl
import com.example.myapplication.ui.MainActivity
import dagger.Component

@PostScope
@Component(
    modules = [PostModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

    fun injectPostRepo(): PostRepositoryImpl

    fun injectDataManagerAccessor(): DataManagerAccessor

    fun injectDataManager(): DataManager
}