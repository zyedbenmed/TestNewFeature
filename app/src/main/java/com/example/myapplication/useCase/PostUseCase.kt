package com.example.myapplication.useCase

import com.example.myapplication.models.PostModel
import io.reactivex.Observable

interface PostUseCase {

    fun getPosts(): Observable<List<PostModel>>
}