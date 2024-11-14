package co.tiagoaguiar.meuprimeiroaplicativo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // O R. ele chama alguma informação de outra pasta

        val txtUsername: TextView = findViewById(R.id.txt_username)
        val txtEmail: TextView = findViewById(R.id.txt_email)

        txtUsername.text = "Olá mundo!"
        txtEmail.setText(R.string.email)
        // Nos temos pastas específicas que informa algumas cores ou textos específicos, isso serve
        // para facilitar as alterações ou atualizações do app

    }
}