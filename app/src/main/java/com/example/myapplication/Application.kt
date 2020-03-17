package com.example.myapplication

import android.app.Application
import com.example.myapplication.dagger.component.AppComponent
import com.example.myapplication.dagger.component.DaggerAppComponent
import com.example.myapplication.dagger.module.AppModule
import com.example.myapplication.dagger.module.NetworkModule
import com.example.myapplication.dagger.module.PostModule
import dagger.Component
import timber.log.Timber

open class Application : Application() {


    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupDagger()
    }

    private fun setupDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()

    }

    private fun setupTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }



}