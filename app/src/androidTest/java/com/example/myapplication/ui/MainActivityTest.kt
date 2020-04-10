package com.example.myapplication.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myapplication.EspressoIdlingResourceRule
import com.example.myapplication.FakeDataManager
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.models.PostModel
import com.example.myapplication.models.PostResponse
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.reactivex.Observable
import org.junit.Test

import org.junit.Ignore
import org.junit.Rule
import java.util.*

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

//    @get: Rule
//    val espressoIdlingResourceRule = EspressoIdlingResourceRule()

    private val realValue =
        "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"

    private val mockedValue = "Mock Successful"

    private val post: PostResponse = PostResponse(
        userId = 1,
        id = 1,
        title = "0222",
        body = mockedValue
    )

    private lateinit var list: Observable<List<PostResponse>>
    private val mockedCardList = mutableListOf<PostResponse>()

    @Test
    fun test_TextView_Text() {
        val fakeDataManager = FakeDataManager()
//        val dataManagerAccessor = mockk<DataManagerAccessor>()
        val apiService: ApiService = mockk()
        mockedCardList.add(post)
        list = Observable.fromArray(mockedCardList)
//        every {  dataManagerAccessor.accessGetPosts()} answers {
//            fakeDataManager.getPosts()
//        }
        every { apiService.getPosts() } returns list
        onView(ViewMatchers.withText(mockedValue)).check(matches(isDisplayed()))
    }

    @Test
    @Ignore
    fun getViewModeFactory() {
    }

    @Test
    @Ignore
    fun setViewModeFactory() {
    }


}