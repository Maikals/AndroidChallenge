package com.example.miquelcastanys.androidchallenge.presentation.publicRepositoriesList

import android.content.Context
import android.util.Log
import com.example.miquelcastanys.androidchallenge.R
import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSourceImpl
import com.example.miquelcastanys.androidchallenge.presentation.base.UseCase
import com.example.miquelcastanys.androidchallenge.presentation.model.domain.PublicRepositoriesResponse
import com.example.miquelcastanys.androidchallenge.presentation.model.mappers.PublicRepositoriesResponseMapper
import com.example.miquelcastanys.androidchallenge.presentation.model.presentation.PublicRepository
import com.example.miquelcastanys.androidchallenge.presentation.useCases.PublicRepositoriesUseCase
import com.example.miquelcastanys.androidchallenge.presentation.utils.Constants
import java.lang.ref.WeakReference


class PublicRepositoriesPresenter : PublicRepositoriesContract.Presenter {

    var context: WeakReference<Context>? = null
    var view: WeakReference<PublicRepositoriesContract.View>? = null
    private var repository: AndroidChallengeSourceImpl? = null
    private var publicRepositoryList: ArrayList<PublicRepository>? = null
    private var isLastPage = false
    private var currentPage = 0

    companion object {
        private const val TAG: String = "RepositoriesPresenter"
    }

    override fun start() {
        showProgressView()
        initializeAttributes()
        getPublicRepositories()
    }

    override fun attach(context: Context, view: PublicRepositoriesContract.View, repository: AndroidChallengeSourceImpl) {
        this.context = WeakReference(context)
        this.view = WeakReference(view)
        this.repository = repository
    }

    private fun showProgressView() {
        if ((view?.get() is PublicRepositoriesContract.View && publicRepositoryList == null)
                || publicRepositoryList!!.isEmpty())
            view?.get()!!.showProgressView()
    }

    private fun initializeAttributes() {
        if (publicRepositoryList == null) publicRepositoryList = ArrayList()
        else publicRepositoryList?.clear()
        currentPage = 0
        isLastPage = false
    }

    override fun getPublicRepositories() {
        repository.let {
            val token = (context?.get() as Context).getString(R.string.token) //change for your own token
            PublicRepositoriesUseCase(repository!!)
                    .getAsync(Constants.USER,
                            ++currentPage,
                            Constants.PAGE_SIZE,
                            token, object : UseCase<List<PublicRepositoriesResponse>> {
                        override fun onSuccess(item: List<PublicRepositoriesResponse>) {
                            manageResult(item)
                        }

                        override fun onError(code: Int) {
                            manageError()
                        }

                    })
        }
    }

    private fun manageResult(item: List<PublicRepositoriesResponse>) {
        Log.d(TAG, "currentPage = " + currentPage)
        if (item.isEmpty()) isLastPage = true
        if (view?.get() is PublicRepositoriesContract.View && view?.get() != null) {
            addToCurrentList(PublicRepositoriesResponseMapper.turnIntoPublicRepositoryList(item))
            view?.get()!!.getPublicRepositoriesOk(publicRepositoryList!!)
            view?.get()!!.hideProgressView()
        }
    }

    private fun manageError() {
        if (view?.get() is PublicRepositoriesContract.View && view?.get() != null) {
            view?.get()!!.getPublicRepositoriesKO()
            view?.get()!!.hideProgressView()
        }
    }

    private fun addToCurrentList(turnIntoPublicRepositoryList: List<PublicRepository>) {
        if (!publicRepositoryList?.isEmpty()!!) removeFooter()
        publicRepositoryList?.addAll(turnIntoPublicRepositoryList)
        addFooter()
    }


    private fun removeFooter() {
        if (publicRepositoryList != null)
            publicRepositoryList!!.removeAll { it.type == Constants.FOOTER_TYPE }
    }

    private fun addFooter() {
        if (!isLastPage)
            publicRepositoryList?.add(PublicRepository(null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    Constants.FOOTER_TYPE))
    }

    override fun isLastPage(): Boolean? = isLastPage

    override fun getRepositoriesList(): List<PublicRepository>? = publicRepositoryList

    override fun detach() {
        context?.clear()
        view?.clear()
        repository = null
    }

}