package com.example.myapplication.dagger.component

import android.content.Context
import com.example.myapplication.Application
import com.example.myapplication.dagger.module.AppModule
import com.example.myapplication.dagger.module.NetworkModule
import com.example.myapplication.dagger.module.PostModule
import com.example.myapplication.dagger.qualifier.ApplicationContext
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepositoryImpl
import com.example.myapplication.ui.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun injectApiService(): ApiService

//    fun injectPostRepo(): PostRepositoryImpl

//    fun injectDataManagerAccessor(): DataManagerAccessor

//    fun injectDataManager(): DataManager

    @ApplicationContext
    fun injectContext(): Context

//    fun injectActivity(mainActivity: MainActivity)
}