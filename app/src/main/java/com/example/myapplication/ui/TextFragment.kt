/*------------------------------------------------------------------------------
 - Copyright (c) Created by zied.ben-mohamed
 - Last modified on 3/26/20 6:10 PM
 -----------------------------------------------------------------------------*/

package com.example.myapplication.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Application

import com.example.myapplication.R
import com.example.myapplication.common.BaseVMActivity
import com.example.myapplication.common.BaseVMFragment
import com.example.myapplication.dagger.component.ActivityComponent
import com.example.myapplication.dagger.component.DaggerActivityComponent
import com.example.myapplication.dagger.module.PostModule
import kotlinx.android.synthetic.main.text_fragment.*
import javax.inject.Inject

class TextFragment : BaseVMFragment<TextViewModel>() {

    companion object {
        fun newInstance() = TextFragment()
    }

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().postModule(PostModule())
            .appComponent(Application.appComponent).build()
    }

    override val viewModel: TextViewModel by injectViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activityComponent.inject(this)
        return inflater.inflate(R.layout.text_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(TextViewModel::class.java)


        addLiveDataObservers()

        getPosts()




    }

    fun addLiveDataObservers() {


        viewModel.getPostData.observe(viewLifecycleOwner, Observer {
            text.text = it.text
        })
    }

    fun getPosts() {
        viewModel.getPost()
    }
}
