package com.example.myapplication.repositories

import com.example.myapplication.models.PostModel
import io.reactivex.Observable

interface PostRepository {

    fun getPosts(): Observable<List<PostModel>>
}