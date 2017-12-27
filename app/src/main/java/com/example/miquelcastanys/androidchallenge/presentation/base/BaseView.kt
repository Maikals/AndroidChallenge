package com.example.miquelcastanys.androidchallenge.presentation.base

interface BaseView <in T> {
    fun setPresenter(presenter: T)
}