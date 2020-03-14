package com.example.myapplication.repositories

import com.example.myapplication.data.api.ApiService
import com.example.myapplication.models.PostModel
import com.example.myapplication.models.PostResponse
import io.reactivex.Observable

class PostRepositoryImpl(private val postApi: ApiService) : PostRepository {


    override fun getPosts(): Observable<List<PostModel>> {
        return postApi.getPosts().map { map(it) }
    }

    private fun map(list: List<PostResponse>): List<PostModel> {
        val firstPost = list[0]
        val list = mutableListOf<PostModel>()
        val post1  = PostModel(
            userId = firstPost.userId,
            id = firstPost.id,
            title = firstPost.title,
            text = firstPost.body
        )
        list.add(post1)
        return list

    }
}