package com.example.miquelcastanys.androidchallenge.domain.data.api

object AndroidChallengeService {
    fun getService(): ServerApi = AndroidChallengeRestApiClient.createService(ServerApi::class.java)

}