package com.example.myapplication.ui

import com.example.myapplication.FakeDataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.myapplication.Application
import com.example.myapplication.EspressoIdlingResource
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.fakes.DaggerFakePostComponent
import com.example.myapplication.fakes.FakePostModule
import com.example.myapplication.utils.TaskExecutorWithIdlingResourceRule

import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextFragmentTest {

//    @Rule
//    @JvmField
//    val executorRule = TaskExecutorWithIdlingResourceRule()
//    @Rule
//    @JvmField
//    val countingAppExecutors = EspressoIdlingResource

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    private val fakeDataManager = FakeDataManager()

    @MockK
    private val dataManager = DataManager()

    @MockK
    private val dataManagerAccessor = DataManagerAccessor(dataManager = fakeDataManager)

    @MockK
    private val textViewModel = TextViewModel(dataManagerAccessor)

    private val mockedValue = "Mock Successful"

    @Before
    fun initTestDagger() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application

        val component = DaggerFakePostComponent.builder()
            .fakePostModule(FakePostModule(fakeDataManager))
            .activityComponent(MainActivity.activityComponent)
            .build()

        Application.appComponent = component

    }

//    @Before
//    fun setUp() {
//        val screnario = launchFragmentInContainer{
//            TextFragment().apply {
//                viewModelFactory =  createFor(textViewModel)
//            }
//        }
//
//        every { dataManager.getPosts()} answers {
//            fakeDataManager.getPosts()
//        }
//    }

    @Test
    fun test() {
        Espresso.onView(ViewMatchers.withText(mockedValue))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class $modelClass")
            }
        }
    }
}