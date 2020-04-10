/*------------------------------------------------------------------------------
 -
 - Copyright (c) Created by zied.ben-mohamed on 4/10/20 3:53 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myapplication.ui.MainActivity
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//testInstrumentationRunner "com.example.myapplication.MockRunner"
//testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
class MainTestWithMockServer {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val mockServer = MockWebServer()

    @Before
    fun setUp() {

        mockServer.start(8080)
    }

//    @After
//    fun tearDown() {
//        mockServer.shutdown()
//    }

    @Test
    fun test_mock_ws_call() {
        mockServer.dispatcher = MockServerDispatcher.RequestDispatcher()

        onView(withId(R.id.button)).perform(click())
        Thread.sleep(10000)

        onView(withId(R.id.button)).check(matches(withText("YESYES")))

        Thread.sleep(10000)
    }

}