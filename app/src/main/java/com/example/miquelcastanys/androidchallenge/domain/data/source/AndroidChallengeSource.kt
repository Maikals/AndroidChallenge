package com.example.miquelcastanys.androidchallenge.domain.data.source

import com.example.miquelcastanys.androidchallenge.domain.model.PublicRepositoriesResponse


interface AndroidChallengeSource {
    interface GetPublicRepositoriesCallback {
        fun onGetPublicRepositoriesResponse(publicRepositoriesResponse: List<PublicRepositoriesResponse>)
        fun onGetError(errorCode: Int?)
    }

    fun getPublicRepositories(user: String, page: Int, pageSize: Int, token: String, callback: GetPublicRepositoriesCallback)
}