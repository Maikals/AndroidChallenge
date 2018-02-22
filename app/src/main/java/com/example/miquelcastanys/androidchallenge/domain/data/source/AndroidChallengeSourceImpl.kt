package com.example.miquelcastanys.androidchallenge.domain.data.source

import com.example.miquelcastanys.androidchallenge.domain.data.DataConstants
import com.example.miquelcastanys.androidchallenge.domain.data.api.AndroidChallengeService
import com.example.miquelcastanys.androidchallenge.presentation.model.domain.PublicRepositoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AndroidChallengeSourceImpl : AndroidChallengeSource {
    private val repository = AndroidChallengeService.getService()
    override fun getPublicRepositories(user: String, page: Int, pageSize: Int, token: String,  callback: AndroidChallengeSource.GetPublicRepositoriesCallback) {
        val publicRepos = repository.getPublicRepos(user, page, pageSize, token)
        publicRepos.enqueue(object : Callback<List<PublicRepositoriesResponse>>{

            override fun onResponse(call: Call<List<PublicRepositoriesResponse>>?, response: Response<List<PublicRepositoriesResponse>>?) {
                if (response?.code() == DataConstants.REQUEST_CODE_OK) {
                    if (response.body() != null)
                        callback.onGetPublicRepositoriesResponse(response.body()!!)
                    else
                        callback.onGetError(DataConstants.REQUEST_CODE_NOT_FOUND)
                } else
                    callback.onGetError(response?.code())
            }

            override fun onFailure(call: Call<List<PublicRepositoriesResponse>>?, t: Throwable?) =
                callback.onGetError(DataConstants.REQUEST_CODE_UNKNOWN_ERROR)
        })
    }
}