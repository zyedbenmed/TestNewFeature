package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.EspressoIdlingResource
import com.example.myapplication.common.BaseViewModel
import com.example.myapplication.dataManager.DataManagerAccessor
import com.example.myapplication.models.PostModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class TextViewModel @Inject constructor(private val dataManagerAccessor: DataManagerAccessor) :
    BaseViewModel() {
    val getPostData: MutableLiveData<PostModel> = MutableLiveData()


    fun getPost() {
//        EspressoIdlingResource.increment()
        toggleLoading(true)

        subscribe(dataManagerAccessor.accessGetPosts(), Consumer {
            toggleLoading(false)
            getPostData.postValue(it[0])
//            EspressoIdlingResource.decrement()

        }, Consumer {
            toggleLoading(false)
//            if (it is RetrofitException)
            errorEvent.postValue(it.message)
//            EspressoIdlingResource.decrement()
        })
    }


}