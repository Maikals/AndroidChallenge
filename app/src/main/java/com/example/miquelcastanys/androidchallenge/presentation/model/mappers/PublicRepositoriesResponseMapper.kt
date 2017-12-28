package com.example.miquelcastanys.androidchallenge.presentation.model.mappers

import com.example.miquelcastanys.androidchallenge.domain.model.PublicRepositoriesResponse
import com.example.miquelcastanys.androidchallenge.presentation.model.PublicRepository

object PublicRepositoriesResponseMapper {

    fun turnIntoPublicRepositoryList(publicRepositoryResponseList: List<PublicRepositoriesResponse>)
            : List<PublicRepository> {
        val publicRepositoryArray = ArrayList<PublicRepository>()
        publicRepositoryResponseList.forEach {
            publicRepositoryArray.add(turnIntoPublicRepository(it))
        }
        return publicRepositoryArray
    }

    private fun turnIntoPublicRepository(it: PublicRepositoriesResponse): PublicRepository =
            PublicRepository(it.name, it.description, it.owner?.login, it.isFork, it.owner?.html_url, it.html_url)
}