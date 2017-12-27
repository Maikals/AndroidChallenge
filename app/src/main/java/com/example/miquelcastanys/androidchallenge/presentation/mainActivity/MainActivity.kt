package com.example.miquelcastanys.androidchallenge.presentation.mainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.miquelcastanys.androidchallenge.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar()

    }

    private fun setToolbar() {
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }
}
