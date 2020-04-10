/*------------------------------------------------------------------------------
 - Copyright (c) Created by zied.ben-mohamed
 - Last modified on 4/10/20 3:07 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication

import com.example.myapplication.dagger.component.DaggerAppComponent
import com.example.myapplication.dagger.module.AppModule
import com.example.myapplication.dagger.module.NetworkModule

class ApplicationTest : Application() {

    override fun setupDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkTestModule())
            .build()
    }
}