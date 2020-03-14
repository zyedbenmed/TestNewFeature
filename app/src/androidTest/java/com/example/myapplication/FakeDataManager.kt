package com.example.myapplication

import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.models.PostModel
import com.example.myapplication.repositories.PostRepositoryImpl
import io.reactivex.Observable

class FakeDataManager : DataManager() {


    private val mockedValue = "Mock Successful"

    private val post: PostModel = PostModel(
        userId = 1,
        id = 1,
        title = "0222",
        text = mockedValue
    )

    private lateinit var list: Observable<List<PostModel>>
    private val mockedCardList = mutableListOf<PostModel>()

    init {

        mockedCardList.add(post)
        list = Observable.fromArray(mockedCardList)
    }


    override
    fun getPosts(): Observable<List<PostModel>> {
        return list
    }
}