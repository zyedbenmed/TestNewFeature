/*------------------------------------------------------------------------------
 -
 - Copyright (c) Created by zied.ben-mohamed on 4/10/20 4:48 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import androidx.test.runner.AndroidJUnitRunner

class MockRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll()
        StrictMode.setThreadPolicy(policy.build())
        super.onCreate(arguments)
    }

    @Throws(
        InstantiationException::class,
        IllegalAccessException::class,
        ClassNotFoundException::class
    )
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, ApplicationTest::class.java.name, context)
    }

}