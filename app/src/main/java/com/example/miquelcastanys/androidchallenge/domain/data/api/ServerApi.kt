package com.example.miquelcastanys.androidchallenge.domain.data.api

import com.example.miquelcastanys.androidchallenge.presentation.model.domain.PublicRepositoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ServerApi {
    @GET("/users/{user}/repos")
    fun getPublicRepos(@Path("user") user: String,
                       @Query("page") page: Int? = null,
                       @Query("per_page") pageSize: Int? = null,
                       @Query("access_token") token: String?): Call<List<PublicRepositoriesResponse>>
}