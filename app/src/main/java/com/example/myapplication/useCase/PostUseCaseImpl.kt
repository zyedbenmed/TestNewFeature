package com.example.myapplication.useCase

import com.example.myapplication.models.PostModel
import com.example.myapplication.repositories.PostRepository
import io.reactivex.Observable

class PostUseCaseImpl(private val postRepository: PostRepository) : PostUseCase {

    override fun getPosts(): Observable<List<PostModel>> {
        return postRepository.getPosts()
    }
}