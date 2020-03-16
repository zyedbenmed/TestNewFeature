package com.example.myapplication.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.common.BaseActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Application
import com.example.myapplication.common.BaseVMActivity
import com.example.myapplication.common.DaggerViewModelFactory
import com.example.myapplication.common.replaceFragmentNoAddToBackStack
import com.example.myapplication.dagger.component.ActivityComponent
import com.example.myapplication.dagger.component.DaggerActivityComponent
import com.example.myapplication.dagger.module.PostModule
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.TestOnly
import javax.inject.Inject

class MainActivity : BaseVMActivity<MainViewModel>() {


    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().postModule(PostModule())
            .appComponent(Application.appComponent).build()
    }

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory

    override val viewModel: MainViewModel by injectViewModel()

    override fun canGoBack(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)

        intent?.let {
            replaceFragmentNoAddToBackStack(TextFragment(), R.id.main_container)
        }

//        getPosts()

//        viewModel.getPostData.observe(this, Observer {
//            text.text = it.text
//        })

    }

    fun getPosts() {
//        viewModel.getPost()
    }

}
