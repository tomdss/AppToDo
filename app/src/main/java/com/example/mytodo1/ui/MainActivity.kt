package com.example.mytodo1.ui

import android.os.Bundle
import com.example.mytodo1.R
import com.example.mytodo1.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        // init View
        // Check Internet
//        isOnline(baseContext)
//        val myString = "Hello Everyone"
//        val result = myString.removeFirstLastChar()
//        Log.i("MainActivity", result)
        loadFragment(R.id.flLayout, LoginFragment())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}