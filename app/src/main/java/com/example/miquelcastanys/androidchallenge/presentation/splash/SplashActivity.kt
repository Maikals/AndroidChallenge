package com.example.miquelcastanys.androidchallenge.presentation.splash

import android.content.Intent
import android.os.Bundle
import com.example.miquelcastanys.androidchallenge.presentation.base.BaseActivity
import com.example.miquelcastanys.androidchallenge.presentation.mainActivity.MainActivity


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}