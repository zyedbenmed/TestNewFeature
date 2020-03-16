package com.example.myapplication.common

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}


fun AppCompatActivity.replaceFragmentNoAddToBackStack(fragment: Fragment, container: Int) {
    val className = fragment.javaClass.simpleName
    supportFragmentManager
        .beginTransaction()
        .add(container, fragment, className)
        .commit()
}