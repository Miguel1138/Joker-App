package co.tiagoaguiar.tutorial.jokerappdev.datasource

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun findAllJokeCategories(
        @Query("apiKey") apiKey: String = HTTPClient.getApiAccessKey()
    ): Call<List<String>>

    @GET("jokes/random")
    fun findJoke(
        @Query("category") categoryName: String? = null,
        @Query("apiKey") apiKey: String = HTTPClient.getApiAccessKey()
    ): Call<Joke>

}