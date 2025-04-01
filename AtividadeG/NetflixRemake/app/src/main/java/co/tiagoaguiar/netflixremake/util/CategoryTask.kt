package co.tiagoaguiar.netflixremake.util

import android.os.Handler
import android.os.Looper
import android.util.Log
import co.tiagoaguiar.netflixremake.model.Category
import co.tiagoaguiar.netflixremake.model.Movie
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class CategoryTask(private val callback: Callback) {
    private  val handler = Handler(Looper.getMainLooper())
    private val executor = Executors.newSingleThreadExecutor()

    interface Callback {
        fun onPreExecute()
        fun onResult (categories: List<Category>)
        fun onFailure(message: String)
    }

    fun execute(url: String) {
        callback.onPreExecute()
        // Nessa momento, estamos utilizando a UI-thread (1)

        executor.execute {
            var urlConnection: HttpsURLConnection? = null
            var buffer: BufferedInputStream? = null
            var stream: InputStream? = null
            try {
                // Nessa momento, estamos utilizando a NOVA-thread [thread paealela] (2)
                val requestURL = URL(url) // Abrir uma URl
                urlConnection = requestURL.openConnection() as HttpsURLConnection //  Abrir a conexão
                urlConnection.readTimeout = 2000 // Tempo leitura (2s)
                urlConnection.connectTimeout = 2000 // Tempo conexão (2s)
                val statusCode: Int = urlConnection.responseCode
                if (statusCode > 400) {
                    throw IOException("Erro na comunicação com o servidor")
                }
//                // Formula 1: Simples e rápida
//                val stream = urlConnection.inputStream // Sequência bytes
//                val jsonAsString = stream.bufferedReader().use {it.readText()} // Bytes -> String
//                Log.i("Teste", jsonAsString)

                // Formula 2: Bytes -> String
                stream = urlConnection.inputStream // Sequência bytes
                buffer = BufferedInputStream(stream)
                val jsonAsString = toString(buffer)
                // O JSON está preparado para ser convertido em um DATA CLASS!!
//                Log.i("Teste", jsonAsString

                val categories = toCategories(jsonAsString)

                handler.post {
                    // Aqui roda dentro de UI-thread
                    callback.onResult(categories)
                }

            } catch (e: IOException) {
                val message = e.message ?: "Erro desconhecido"
                Log.e("Teste", message, e)
                handler.post {
                    callback.onFailure(message)
                }
            } finally {
                urlConnection?.disconnect()
                stream?.close()
                buffer?.close()
            }
        }
    }

    // Formula 2: Bytes -> String
    private fun toString(stream: InputStream) : String {
        val bytes = ByteArray(1024)
        val baos = ByteArrayOutputStream()
        var read: Int
        while(true) {
            read = stream.read(bytes)
            if (read <=0) {
                break
            }
            baos.write(bytes, 0, read)
        }
        return String(baos.toByteArray())
    }

    private fun toCategories(jsonAsStream: String) : List<Category> {
        val categories = mutableListOf<Category>()
        val jsonRoot = JSONObject(jsonAsStream)
        val jsonCategories = jsonRoot.getJSONArray("category")
        for (i in 0 until jsonCategories.length()) {
            val jsonCategory = jsonCategories.getJSONObject(i)
            val title = jsonCategory.getString("title")
            val jsonMovies = jsonCategory.getJSONArray("movie")

            val movies = mutableListOf<Movie>()
            for (j in 0 until jsonMovies.length()) {
                val jsonMovie = jsonMovies.getJSONObject(j)
                val id = jsonMovie.getInt("id")
                val coverUrl = jsonMovie.getString("cover_url")
                movies.add(Movie(id, coverUrl))
            }
            categories.add(Category(title, movies))
        }
        return categories
    }
}