package com.example.miquelcastanys.androidchallenge

import android.app.Application
import android.os.SystemClock
import com.example.miquelcastanys.androidchallenge.presentation.utils.Constants
import java.util.concurrent.TimeUnit


class AndroidChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(Constants.SPLASH_TIME))
    }
}