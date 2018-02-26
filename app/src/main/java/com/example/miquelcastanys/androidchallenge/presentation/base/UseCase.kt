package com.example.miquelcastanys.androidchallenge.presentation.base


interface UseCase <in T>  {
    fun onSuccess(item: T)
    fun onError(code: Int)
}