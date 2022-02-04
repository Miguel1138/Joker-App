package co.tiagoaguiar.tutorial.jokerappdev.datasource

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeDayRemoteDataSource {

    fun findJokeDay(callback: ReturnCallback<Joke>) {
        HTTPClient.retrofit()
            .create(ChuckNorrisApi::class.java)
            .findJoke()
            .enqueue(joke(callback))
    }

    private fun joke(callback: ReturnCallback<Joke>) = object : Callback<Joke> {
        override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
            if (response.isSuccessful) {
                val joke = response.body()
                callback.onSuccess(joke ?: throw RuntimeException("Joke not found."))
            } else {
                val error = response.errorBody()?.string()
                callback.onError(error ?: "Erro desconhecido")
            }
            callback.onComplete()
        }

        override fun onFailure(call: Call<Joke>, t: Throwable) {
            callback.onError(t.message ?: "Erro interno")
            callback.onComplete()
        }
    }

}
