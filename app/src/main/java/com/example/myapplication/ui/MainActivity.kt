package com.example.myapplication.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.common.BaseActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Application
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.dagger.component.ActivityComponent
import com.example.myapplication.dagger.component.DaggerActivityComponent
import com.example.myapplication.dagger.module.PostModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {


    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().postModule(PostModule())
            .appComponent(Application.appComponent).build()
    }

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun canGoBack(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)

        viewModel.getPost()

        viewModel.getPostData.observe(this, Observer {
            text.text = it.text
        })

    }
}
