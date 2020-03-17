package com.example.myapplication.fakes

import com.example.myapplication.FakeDataManager
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
import javax.inject.Singleton

@Module
class FakePostModule(private val dataManager: DataManager) {


//    @Provides
//    @PostScope
//    fun provideDataManagerAccessor() : DataManagerAccessor {
//        return DataManagerAccessor(fakeDataManager)
//    }

    @Provides
//    @PostScope
    @TestScope
//    @Singleton
    fun provideDataManager(): DataManager {
        return dataManager
    }

}