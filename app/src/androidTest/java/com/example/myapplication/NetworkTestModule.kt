/*------------------------------------------------------------------------------
 -
 - Copyright (c) Created by zied.ben-mohamed on 4/10/20 3:13 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication

import com.example.myapplication.dagger.module.NetworkModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkTestModule : NetworkModule() {

    @Provides
    @Singleton
    override fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}