package com.example.myapplication.dataManager

import com.example.myapplication.common.BaseDataManager
import com.example.myapplication.models.PostModel
import com.example.myapplication.repositories.PostRepository
import com.example.myapplication.repositories.PostRepositoryImpl
import com.example.myapplication.useCase.PostUseCase
import io.reactivex.Observable
import javax.inject.Inject

open class DataManager() : BaseDataManager() {
    private lateinit var postUseCase: PostUseCase
    constructor(postUseCase: PostUseCase) : this() {
        this.postUseCase = postUseCase
    }


    open fun getPosts(): Observable<List<PostModel>> {
        return postUseCase.getPosts()
    }

}
