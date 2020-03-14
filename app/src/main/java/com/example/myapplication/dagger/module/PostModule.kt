package com.example.myapplication.dagger.module

import com.example.myapplication.dagger.qualifier.PostScope
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.dataManager.DataManager
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.repositories.PostRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class PostModule {

    @Provides
    @PostScope
    fun providePostRepository(apiService: ApiService): PostRepositoryImpl {
        return PostRepositoryImpl(apiService)
    }

    @Provides
    @PostScope
    fun provideDataManagerAccessor(dataManager: DataManager): DataManagerAccessor {
        return DataManagerAccessor(dataManager)
    }

    @Provides
    @PostScope
    fun provideDataManager(postRepositoryImpl: PostRepositoryImpl): DataManager {
        return DataManager(postRepositoryImpl)
    }

}