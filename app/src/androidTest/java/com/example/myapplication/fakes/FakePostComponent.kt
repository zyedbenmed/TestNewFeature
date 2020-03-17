package com.example.myapplication.fakes

import android.content.Context
import com.example.myapplication.FakeDataManager
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dagger.component.ActivityComponent
import com.example.myapplication.dagger.component.AppComponent
import com.example.myapplication.dagger.module.PostModule
import com.example.myapplication.dagger.qualifier.PostScope
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepository
import com.example.myapplication.ui.TextFragment
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class TestScope

//@PostScope
//@Singleton
@TestScope
@Component(modules = [FakePostModule::class], dependencies = [ActivityComponent::class])
interface FakePostComponent : AppComponent {
    override fun injectApiService(): ApiService

    override fun injectContext(): Context

}