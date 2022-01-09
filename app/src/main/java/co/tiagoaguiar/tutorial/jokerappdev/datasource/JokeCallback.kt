package co.tiagoaguiar.tutorial.jokerappdev.datasource

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)
    fun onError(message: String)
    fun onComplete()

}