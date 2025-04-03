package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import android.graphics.Color.HSVToColor
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource() // Fazendo isso eu
    // deixo o código mais organizado
) : ListCategoryCallback {
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//        for (category in response) {
//            categories.add(CategoryItem(category))
//        }

        // Fazendo isso de uma forma mais enxuta
//        val categories = response.map { category ->
//            CategoryItem(category)
//        }

        // E da para deixar uma forma mais enxuta ainda:
//        val categories = response.map { Category(it, 0Xffcfd571) }

        val start = 40
        val end= 190
        val diff = (end - start) / response.size
        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f,
            )

            Category(s, Color.HSVToColor(hsv).toLong())
        }

        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

    // Essa função tem como objetivo similar uma requisição HTTP
//    private fun fakeRequest() {
//        Handler(Looper.getMainLooper()).postDelayed({
//            val response = arrayListOf(
//                "Categoria 1",
//                "Categoria 2",
//                "Categoria 3",
//                "Categoria 4"
//            )
//            // Aqui a lista falsa já está pronta
//            onSuccess(response)
//            // Lembrete o servidor pode respoder SUCESSO ou FALHA
////            onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE")
//            onComplete()
//        }, 2000)
//    }
}