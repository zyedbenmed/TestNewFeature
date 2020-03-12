package com.example.myapplication.dataManager

import com.example.myapplication.models.PostModel
import io.reactivex.Observable
import timber.log.Timber


class DataManagerAccessor: DataManager() {

    fun accessGetPosts(): Observable<PostModel> {
        Timber.i("getPost is being called")
        return getPosts().compose(io())
    }
}