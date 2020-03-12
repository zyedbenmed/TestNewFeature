package com.example.myapplication.dataManager

import com.example.myapplication.common.BaseDataManager
import com.example.myapplication.models.PostModel
import io.reactivex.Observable

open class DataManager: BaseDataManager() {


    protected fun getPosts(): Observable<PostModel> {
        return cardsUseCase.getPosts()
    }

}
