package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.datasource.CategoryRemoteDatasource
import co.tiagoaguiar.tutorial.jokerappdev.datasource.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.JokeCategory
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val datasource: CategoryRemoteDatasource = CategoryRemoteDatasource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgressBar()
        datasource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val categories = response.map { category ->
            JokeCategory(category, 0xffff0000)
        }
        view.showCategories(categories)
    }

    override fun onError(message: String) = view.showFailure(message)

    override fun onComplete() = view.hideProgressBar()

}

