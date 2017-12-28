package com.example.miquelcastanys.androidchallenge.presentation.mainActivity

import android.content.Context
import com.example.miquelcastanys.androidchallenge.presentation.base.BasePresenter
import com.example.miquelcastanys.androidchallenge.presentation.base.BaseView
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository


interface PublicRepositoriesContract {
    interface View : BaseView<Presenter> {
        fun getPublicRepositoriesOk(publicRepositoryList: List<PublicRepository>)
        fun getPublicRepositoriesKO()

    }

    interface Presenter: BasePresenter<Context, View> {
        fun getPublicRepositories()
    }
}