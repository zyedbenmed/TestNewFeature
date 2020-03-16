package com.example.myapplication.common

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Application
import com.example.myapplication.R
import com.example.myapplication.dagger.component.ActivityComponent
import com.example.myapplication.dagger.component.DaggerActivityComponent
import com.example.myapplication.dagger.module.PostModule

abstract class BaseActivity : AppCompatActivity() {

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().postModule(PostModule())
            .appComponent(Application.appComponent).build()
    }

    private val container: ViewGroup by lazy {
        findViewById<ViewGroup>(android.R.id.content)
    }
    private val loading: View by lazy {
        LayoutInflater.from(this).inflate(R.layout.layout_loading, container, false)
    }
//    protected val viewModel: V by lazy {
//        setViewModel()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel.loading.observe(this,
//            Observer<Boolean> { loading -> toggleLoading(loading, false) })
//
//        viewModel.errorEvent.observe(this, Observer {
//            if (it != null)
//                showBottomDialog(it, true)
//            else
//                showBottomDialog("Server Error! ", true)
//        })

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        activityComponent.inject(this)
        return super.onCreateView(name, context, attrs)
    }

    fun toggleLoading(show: Boolean, isCancellable: Boolean) {
        if (show) {
            loading.tag = isCancellable
            container.removeView(loading)
            container.addView(loading)
            if (!isCancellable)
                loading.setOnTouchListener { _, _ -> true }
        } else {
            loading.tag = null
            container.removeView(loading)
        }
    }

    private fun showBottomDialog(message: String, isError: Boolean) {
        this.toast(message = message)
    }

    override fun onBackPressed() {
        if (canGoBack()) {
            super.onBackPressed()
        }
    }

    //    abstract fun setViewModel(): V
    abstract fun canGoBack(): Boolean

}