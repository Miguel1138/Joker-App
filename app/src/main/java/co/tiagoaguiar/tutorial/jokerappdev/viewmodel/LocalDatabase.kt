package co.tiagoaguiar.tutorial.jokerappdev.viewmodel

import co.tiagoaguiar.tutorial.jokerappdev.model.JokeCategory
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeCategoryItem

class LocalDatabase {

    companion object {
        private val jokeCategories = arrayListOf(
            JokeCategoryItem(JokeCategory("Categoria 1", 0xffface6e)),
            JokeCategoryItem(JokeCategory("Categoria 2", 0xffecd16d)),
            JokeCategoryItem(JokeCategory("Categoria 3", 0xffded36e)),
            JokeCategoryItem(JokeCategory("Categoria 4", 0xffcfd571)),
        )

        fun getJokeCategories(): List<JokeCategoryItem> = jokeCategories
    }

}
