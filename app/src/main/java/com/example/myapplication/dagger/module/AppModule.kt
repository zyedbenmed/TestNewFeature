package com.example.myapplication.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.Application
import com.example.myapplication.dagger.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@Module(includes = [NetworkModule::class])
abstract class AppModule {
    /**
     *  *** IMPORTANT ***
     * Use activity context for Dialogs (Toast, AlertDialog, SnackBar...)
     * also when starting an Activity and for layout inflation
     * To avoid memory leaks and possible crashes.
     *
     * applicationContext is used to : - start or bind a Service
     *                                 - send or register a broadcast
     *                                 - load resource values
     *
     */
    @Provides
    @ApplicationContext
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    //***************************************************

    @Provides
    @Singleton
    fun provideApplication(application: Application): Application{
        return application
    }

    @Provides
    fun provideSharedPrefs(application: Application): SharedPreferences{
        return application.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    companion object{
        private const val SHARED_PREFERENCES_KEY = "SharedPreferenceProvider"
    }

}