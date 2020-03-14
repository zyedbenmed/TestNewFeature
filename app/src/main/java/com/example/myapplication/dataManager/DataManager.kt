package com.example.myapplication.dataManager

import com.example.myapplication.common.BaseDataManager
import com.example.myapplication.models.PostModel
import com.example.myapplication.repositories.PostRepository
import com.example.myapplication.repositories.PostRepositoryImpl
import io.reactivex.Observable
import javax.inject.Inject

open class DataManager() : BaseDataManager() {
    private lateinit var postRepositoryImpl: PostRepositoryImpl
    constructor(postRepositoryImpl: PostRepositoryImpl) : this() {
        this.postRepositoryImpl = postRepositoryImpl
    }


    open fun getPosts(): Observable<List<PostModel>> {
        return postRepositoryImpl.getPosts()
    }

}
