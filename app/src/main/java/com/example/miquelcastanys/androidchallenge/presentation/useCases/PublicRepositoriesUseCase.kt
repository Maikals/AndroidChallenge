package com.example.miquelcastanys.androidchallenge.presentation.useCases

import com.example.miquelcastanys.androidchallenge.domain.DomainConstants
import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSource
import com.example.miquelcastanys.androidchallenge.domain.data.source.AndroidChallengeSourceImpl
import com.example.miquelcastanys.androidchallenge.presentation.model.domain.PublicRepositoriesResponse
import com.example.miquelcastanys.androidchallenge.presentation.base.UseCase


class PublicRepositoriesUseCase (val repository: AndroidChallengeSourceImpl) {
    fun getAsync(user: String, page: Int, pageSize: Int, token: String, listener: UseCase<List<PublicRepositoriesResponse>>) {
        repository.getPublicRepositories(user, page, pageSize, token, object : AndroidChallengeSource.GetPublicRepositoriesCallback{
            override fun onGetPublicRepositoriesResponse(publicRepositoriesResponse: List<PublicRepositoriesResponse>) {
                listener.onSuccess(publicRepositoriesResponse)
            }

            override fun onGetError(errorCode: Int?) {
                listener.onError(errorCode ?: DomainConstants.REQUEST_CODE_UNKNOWN_ERROR)
            }

        })
    }
}