package com.example.myapplication.dataManager

import com.example.myapplication.common.BaseDataManager
import com.example.myapplication.models.PostModel
import io.reactivex.Observable
import timber.log.Timber


open class DataManagerAccessor(private val dataManager: DataManager) {

    fun accessGetPosts(): Observable<List<PostModel>> {
        Timber.i("getPost is being called")
        return dataManager.getPosts().compose(BaseDataManager().io())
    }
}