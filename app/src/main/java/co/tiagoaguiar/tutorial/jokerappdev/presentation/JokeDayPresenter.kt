package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.datasource.JokeDayRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.datasource.ReturnCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : ReturnCallback<Joke> {

    override fun onSuccess(response: Joke) {
        view.showRandomJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgressBar()
    }

    fun findJokeDay() {
        view.showProgressBar()
        dataSource.findJokeDay(this)
    }

}
