package co.tiagoaguiar.tutorial.jokerappdev.datasource

interface ListCategoryCallback {

    fun onComplete()
    fun onSuccess(response: List<String>)
    fun onError(message: String)

}