package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import android.telecom.CallScreeningService.CallResponse
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {
    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//        for (category in response) {
//            categories.add(CategoryItem(category))
//        }

        // Fazendo isso de uma forma mais enxuta
//        val categories = response.map { category ->
//            CategoryItem(category)
//        }

        // E da para deixar uma forma mais enxuta ainda:
        val categories = response.map { Category(it, 0Xffcfd571) }

        view.showCategories(categories)
    }

    fun onError(message:String) {
        view.showFailure(message)
    }

    fun onComplete() {
        view.hideProgress()
    }

    // Essa função tem como objetivo similar uma requisição HTTP
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )
            // Aqui a lista falsa já está pronta
            onSuccess(response)
            // Lembrete o servidor pode respoder SUCESSO ou FALHA
//            onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE")
            onComplete()
        }, 2000)
    }
}