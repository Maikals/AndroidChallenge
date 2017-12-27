package com.example.miquelcastanys.androidchallenge.domain.data.source

import com.example.miquelcastanys.androidchallenge.domain.data.api.AndroidChallengeService
import com.example.miquelcastanys.androidchallenge.domain.model.PublicRepositoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AndroidChallengeSourceImpl : AndroidChallengeSource {
    val repository = AndroidChallengeService.getService()
    override fun getPublicRepositories(user: String, page: Int, pageSize: Int, callback: AndroidChallengeSource.GetPublicRepositoriesCallback) {
        val publicRepos = repository.getPublicRepos(user, page, pageSize)
        publicRepos.enqueue(object : Callback<List<PublicRepositoriesResponse>>{

            override fun onResponse(call: Call<List<PublicRepositoriesResponse>>?, response: Response<List<PublicRepositoriesResponse>>?) {
                if (response?.code() == 200) {
                    if (response.body() != null)
                        callback.onGetPublicRepositoriesResponse(response.body()!!)
                    else
                        callback.onGetError(404)
                } else
                    callback.onGetError(response?.code())
            }

            override fun onFailure(call: Call<List<PublicRepositoriesResponse>>?, t: Throwable?) =
                callback.onGetError(500)
        })
    }
}