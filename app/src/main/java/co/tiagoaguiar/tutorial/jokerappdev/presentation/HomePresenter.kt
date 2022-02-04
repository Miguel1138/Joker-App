package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import co.tiagoaguiar.tutorial.jokerappdev.datasource.CategoryRemoteDatasource
import co.tiagoaguiar.tutorial.jokerappdev.datasource.ReturnCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.JokeCategory
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val datasource: CategoryRemoteDatasource = CategoryRemoteDatasource()
) : ReturnCallback<List<String>> {

    override fun onSuccess(response: List<String>) {
        val categories = inflateJokeCategoriesBy(response)
        view.showCategories(categories)
    }

    private fun inflateJokeCategoriesBy(response: List<String>): List<JokeCategory> {
        val gradientStart = 40
        val gradientEnd = 190
        val gradientDiff = (gradientEnd - gradientStart) / response.size

        return response.mapIndexed { index, category ->
            val hsv = floatArrayOf(
                gradientStart + (gradientDiff * index).toFloat(),
                100.0f,
                100.0f
            )
            val finalGradient = Color.HSVToColor(hsv).toLong()
            JokeCategory(category, finalGradient)
        }
    }

    override fun onError(message: String) = view.showFailure(message)

    override fun onComplete() = view.hideProgressBar()

    fun findAllCategories() {
        view.showProgressBar()
        datasource.findAllCategories(this)
    }

}

