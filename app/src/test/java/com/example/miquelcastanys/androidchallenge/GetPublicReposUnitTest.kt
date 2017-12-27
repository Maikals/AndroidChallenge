package com.example.miquelcastanys.androidchallenge

import com.example.miquelcastanys.androidchallenge.domain.data.api.AndroidChallengeService
import com.example.miquelcastanys.androidchallenge.domain.model.PublicRepositoriesResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import retrofit2.HttpException
import ru.gildor.coroutines.retrofit.await

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GetPublicReposUnitTest {

    @Test
    fun testGetPublicReposWithTwoElements() {
        val expectedRepos = Gson().fromJson<List<PublicRepositoriesResponse>>(TestConstants.FIRST_PAGE, object : TypeToken<List<PublicRepositoriesResponse>>(){}.type)
        val actualRepos = AndroidChallengeService.getService()
        val reposList = runBlocking { actualRepos.getPublicRepos("xing", 1, 2).await() }
        assert(reposList == expectedRepos)
    }

    @Test
    fun testGetPublicReposWithError() {
        val actualRepos = AndroidChallengeService.getService()
        try {
            runBlocking { actualRepos.getPublicRepos("xoang", 1, 2).await() }
        } catch (e: HttpException) {
            assert(e.response().message() == TestConstants.ERROR_MESSAGE)

        }
    }

}
