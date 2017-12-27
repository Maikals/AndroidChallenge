package com.example.miquelcastanys.androidchallenge.domain.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AndroidChallengeRestApiClient {
    val TIMEOUT_CONNECTION_VALUE = 60L
    val TIMEOUT_READ_VALUE = 60L
    val TIMEOUT_WRITE_VALUE = 60L
    fun <S> createService(serviceClass: Class<S>): S {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECTION_VALUE, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ_VALUE, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE_VALUE, TimeUnit.SECONDS)
        val builder = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
        return builder.client(httpClient.build()).build().create(serviceClass)
    }
}