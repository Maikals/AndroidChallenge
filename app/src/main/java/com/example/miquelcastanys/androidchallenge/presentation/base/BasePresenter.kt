package com.example.miquelcastanys.androidchallenge.presentation.base

import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSourceImpl

interface BasePresenter<in T, in V> {
    fun start()
    fun attach(context: T, view: V, repository: AndroidChallengeSourceImpl)
    fun detach()
}