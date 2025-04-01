package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Category
import co.tiagoaguiar.netflixremake.model.Movie
import co.tiagoaguiar.netflixremake.util.CategoryTask

class MainActivity : AppCompatActivity(), CategoryTask.Callback {
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Teste", "onCreate")

        progress = findViewById(R.id.progress_main)

        val categories = mutableListOf<Category>()
////       Não iremos mais utilizar os dados falsos
//        for (j in 0 until 10) {
//            val movies = mutableListOf<Movie>()
//            for(i in 0 until 15) {
//                val movie = Movie(R.drawable.movie)
//                movies.add(movie)
//            }
//            val category = Category("cat $j" , movies)
//            categories.add(category)
//        }

        val adapter = CategoryAdapter(categories)
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        CategoryTask(this).execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=ceae331e-de73-4e7c-9619-3e0e586acb7b")
    }

    override fun onPreExecute() {
        progress.visibility = View.VISIBLE
    }

    override fun onResult(categories: List<Category>) {
        // Aqui será quando o CategoryTask chamará de volta famoso (callback) - listener
        Log.i("Teste Categories", categories.toString())
        progress.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        progress.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        Log.i("Teste", "onStart")
        // Essa parte serve para mostrar as coisas quando inicializar uma parte, como pedir
        // permissões para acessar o GPS, Camera, Galeria, ou outros.
    }

    override fun onResume() {
        super.onResume()
        Log.i("Teste", "onResume")
        // Essa parte é disparada quando o usuario volta para tela do app, com isso o app pode
        // atualizar as informações, como acontece em app para verificações onde eles utilizam
        // identificações SMS, quando você volta do app a tela esta liberada
    }

    override fun onPause() {
        super.onPause()
        Log.i("Teste", "onPause")
        // Essa parte trabalha junto com o onResume, ele pasicamente é o proceço anterior ao
        // onResume, ele pode ser utilizado para salvar as informasoes para ser continuado o
        // trabalho posteriormente
    }

    override fun onStop() {
        super.onStop()
        Log.i("Teste", "onStop")
        // Essa etapa e a etapa de encerramento do app, normalmente utilizamos essa parte para
        // livrar recursos, basicamente limpando a bagunça antes de ir embora
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Teste", "onDestroy")
        // Essa é a etapa quando o usuário esta encerrando de fato o app, o momento onde o usuario
        // não tem mais acesso ao app, essa parte é mais usada para coleta de informações do
        // sistema como coleta para dados de estatiticas ou outros
    }
}