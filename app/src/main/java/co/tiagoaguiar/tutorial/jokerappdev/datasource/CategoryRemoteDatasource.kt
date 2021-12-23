package co.tiagoaguiar.tutorial.jokerappdev.datasource

import android.os.Handler
import android.os.Looper

class CategoryRemoteDatasource {

    fun findAllCategories(callback: ListCategoryCallback) {
        fakeHttpRequestAndReturn(callback)
    }

    private fun fakeHttpRequestAndReturn(callback: ListCategoryCallback) {
        // Simulating the latency of a server
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val response = arrayListOf(
                    "Categoria 1", "Categoria 2",
                    "Categoria 3", "Categoria 4"
                )
                callback.onSuccess(response)
            } catch (ex: Exception) {
                callback.onError(ex.printStackTrace().toString())
            } finally {
                callback.onComplete()
            }

        }, 4000)
    }

}