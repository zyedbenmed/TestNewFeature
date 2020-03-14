package com.example.myapplication.data.api

import com.example.myapplication.models.PostResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("posts")
    fun getPosts(
    ): Observable<List<PostResponse>>
}