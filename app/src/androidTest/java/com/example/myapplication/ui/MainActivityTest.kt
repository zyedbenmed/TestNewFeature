package com.example.myapplication.ui

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.myapplication.EspressoIdlingResourceRule
import com.example.myapplication.FakeDataManager
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.models.PostModel
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

import org.junit.Ignore
import org.junit.Rule
import org.junit.runner.RunWith
import timber.log.Timber
import java.util.*

@RunWith(AndroidJUnit4::class)
class MainActivityTest {




//    @Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java, true, false)



//    @get: Rule
//    val espressoIdlingResourceRule = EspressoIdlingResourceRule()

    private val realValue =
        "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"

    private val mockedValue = "Mock Successful"

    private val post: PostModel = PostModel(
        userId = 1,
        id = 1,
        title = "0222",
        text = mockedValue
    )

    private lateinit var list: Observable<List<PostModel>>
    private val mockedCardList = mutableListOf<PostModel>()

    private val fakeDataManager = FakeDataManager()

    @MockK
    private val dataManagerAccessor = DataManagerAccessor(dataManager = fakeDataManager)

    @MockK
    private val mainViewModel = MainViewModel(dataManagerAccessor)

    @Before
    fun setUp() {
        val intent = Intent(InstrumentationRegistry.getInstrumentation().targetContext, MainActivity::class.java)
        activityRule.launchActivity(intent)
        activityRule.activity.viewModeFactory =  createViewModelFor(mainViewModel)
    }

    @Test
    fun test_TextView_Text() {
        mockedCardList.add(post)
        list = Observable.fromArray(mockedCardList)
//        every {  dataManagerAccessor.accessGetPosts()} answers {
//            fakeDataManager.getPosts()
//        }
        onView(ViewMatchers.withText(mockedValue)).check(matches(isDisplayed()))

//
//        Truth.assert_().that(list).isEqualTo(listReturned)
//
//
//        Timber.d("List returned from mockk ==> $listReturned")

    }

    fun <T : ViewModel> createViewModelFor(model: T): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class " + modelClass)
            }
        }

}