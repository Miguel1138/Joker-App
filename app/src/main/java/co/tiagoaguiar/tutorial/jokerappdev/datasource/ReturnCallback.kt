package co.tiagoaguiar.tutorial.jokerappdev.datasource


interface ReturnCallback<T> {

    fun onSuccess(response: T)
    fun onError(message: String)
    fun onComplete()

}