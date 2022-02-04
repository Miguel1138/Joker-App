package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.datasource.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.datasource.ReturnCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val datasource: JokeRemoteDataSource = JokeRemoteDataSource()
) : ReturnCallback<Joke> {

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgressBar()
    }

    fun findJokeBy(categoryName: String) {
        view.showProgressBar()
        datasource.findJokeBy(categoryName, this)
    }

}
