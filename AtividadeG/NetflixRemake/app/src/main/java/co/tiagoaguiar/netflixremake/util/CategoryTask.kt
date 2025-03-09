package co.tiagoaguiar.netflixremake.util

import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class CategoryTask {
    fun execute(url: String) {
        // Nessa momento, estamos utilizando a UI-thread (1)
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            try {
                // Nessa momento, estamos utilizando a NOVA-thread [thread paealela] (2)
                val requestURL = URL(url) // Abrir uma URl
                val urlConnection =
                    requestURL.openConnection() as HttpURLConnection //  Abrir a conexão
                urlConnection.readTimeout = 2000 // Tempo leitura (2s)
                urlConnection.connectTimeout = 2000 // Tempo conexão (2s)
                val statusCode: Int = urlConnection.responseCode
                if (statusCode > 400) {
                    throw IOException("Erro na comunicação com o servidor")
                }
                // Formula 1: simples e rápida
                val stream = urlConnection.inputStream // Sequência bytes
                val jsonAsString = stream.bufferedReader().use {it.readText()} // Bytes -> String
                Log.i("Teste", jsonAsString)

                // Formula 2: ????
            } catch (e: IOException) {
                Log.e("Teste", e.message ?: "Erro desconhecido", e)
            }
        }
    }
}