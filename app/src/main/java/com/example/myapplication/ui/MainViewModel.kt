package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.common.BaseViewModel
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.models.PostModel
import io.reactivex.functions.Consumer


class MainViewModel: BaseViewModel() {
    val getPostData: MutableLiveData<PostModel> = MutableLiveData()


    val dataManagerAccessor: DataManagerAccessor = DataManagerAccessor()

    private fun getPost() {
        toggleLoading(true)

        subscribe(dataManagerAccessor.accessGetPosts(), Consumer {
            toggleLoading(false)
            getPostData.postValue(it)

        }, Consumer {
            toggleLoading(false)
//            if (it is RetrofitException)
                errorEvent.postValue(it.message)
        })
    }




}