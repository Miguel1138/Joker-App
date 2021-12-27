package co.tiagoaguiar.tutorial.jokerappdev.datasource

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun findAllJokeCategories(
        @Query("apiKey") apiKey: String = HTTPClient.getApiAccessKey()
    ): Call<List<String>>
}