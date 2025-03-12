package co.tiagoaguiar.netflixremake.util

import android.util.Log
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
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
//                // Formula 1: Simples e rápida
//                val stream = urlConnection.inputStream // Sequência bytes
//                val jsonAsString = stream.bufferedReader().use {it.readText()} // Bytes -> String
//                Log.i("Teste", jsonAsString)

                // Formula 2: Bytes -> String
                val stream = urlConnection.inputStream // Sequência bytes
                val buffer = BufferedInputStream(stream)
                val jsonAsString = toString(buffer)
                Log.i("Teste", jsonAsString)

            } catch (e: IOException) {
                Log.e("Teste", e.message ?: "Erro desconhecido", e)
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
}