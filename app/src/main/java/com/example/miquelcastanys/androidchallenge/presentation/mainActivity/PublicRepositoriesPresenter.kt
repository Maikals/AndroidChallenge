package com.example.miquelcastanys.androidchallenge.presentation.mainActivity

import android.content.Context
import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSourceImpl
import com.example.miquelcastanys.androidchallenge.domain.model.PublicRepositoriesResponse
import com.example.miquelcastanys.androidchallenge.presentation.UseCase
import com.example.miquelcastanys.androidchallenge.presentation.model.mappers.PublicRepositoriesResponseMapper
import java.lang.ref.WeakReference


class PublicRepositoriesPresenter : PublicRepositoriesContract.Presenter {
    var context: WeakReference<Context>? = null
    var view: WeakReference<PublicRepositoriesContract.View>? = null
    var repository: AndroidChallengeSourceImpl? = null
    override fun start() {
        getPublicRepositories()
    }

    override fun attach(context: Context, view: PublicRepositoriesContract.View, repository: AndroidChallengeSourceImpl) {
        this.context = WeakReference(context)
        this.view = WeakReference(view)
        this.repository = repository
    }

    override fun detach() {
        context?.clear()
        view?.clear()
        repository = null
    }

    override fun getPublicRepositories() {
        repository.let{PublicRepositoriesUseCase(repository!!).getAsync("xing", 1, 10, object : UseCase<List<PublicRepositoriesResponse>> {
            override fun onSuccess(item: List<PublicRepositoriesResponse>) {

                (view?.get() as PublicRepositoriesContract.View).getPublicRepositoriesOk(PublicRepositoriesResponseMapper.turnIntoPublicRepositoryList(item))
            }

            override fun onError(code: Int) {

            }

        })}
    }
}