package com.example.myapplication.dagger.component

import com.example.myapplication.common.BaseActivity
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dagger.module.PostModule
import com.example.myapplication.dagger.module.ViewModelModule
import com.example.myapplication.dagger.qualifier.PostScope
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepository
import com.example.myapplication.repositories.PostRepositoryImpl
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.TextFragment
import dagger.Component

@PostScope
@Component(
    modules = [PostModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity)

    fun inject(textFragment: TextFragment)

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

    fun injectPostRepo(): PostRepository

    fun injectDataManagerAccessor(): DataManagerAccessor

    fun injectDataManager(): DataManager
}