package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {
    fun findAllCategories(callback: ListCategoryCallback) {
//        Handler(Looper.getMainLooper()).postDelayed({
//            val response = arrayListOf(
//                "Categoria 1",
//                "Categoria 2",
//                "Categoria 3",
//                "Categoria 4"
//            )
//            // Aqui a lista falsa já está pronta
//            callback.onSuccess(response)
//            // Lembrete o servidor pode respoder SUCESSO ou FALHA
////            onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE")
//            callback.onComplete()
//        }, 2000)

        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .findAllCategories()
            .enqueue(object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful) {
                        val categories = response.body()
                        callback.onSuccess(categories ?: emptyList())
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro Interno")
                    callback.onComplete()
                }
            })
    }
}