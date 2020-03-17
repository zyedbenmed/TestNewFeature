package com.example.myapplication.dagger.module

import com.example.myapplication.dagger.qualifier.PostScope
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepository
import com.example.myapplication.repositories.PostRepositoryImpl
import com.example.myapplication.useCase.PostUseCase
import com.example.myapplication.useCase.PostUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class PostModule {

    @Provides
    @PostScope
    fun providePostRepository(apiService: ApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }

    @Provides
    @PostScope
    fun providePostUseCase(postRepository: PostRepository): PostUseCase {
        return PostUseCaseImpl(postRepository)
    }

    @Provides
    @PostScope
    fun provideDataManager(postUseCase: PostUseCase): DataManager {
        return DataManager(postUseCase)
    }

    @Provides
    @PostScope
    fun provideDataManagerAccessor(dataManager: DataManager): DataManagerAccessor {
        return DataManagerAccessor(dataManager)
    }

}