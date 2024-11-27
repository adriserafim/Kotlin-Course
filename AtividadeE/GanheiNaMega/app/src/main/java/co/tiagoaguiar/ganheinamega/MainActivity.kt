package co.tiagoaguiar.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

// LEMBRETE: Para importar alguma biblioteca, objetos ou outra coisa você pode utilizar o
// Alt + Enter em cima da faze que ira importar automáticamente

class MainActivity : AppCompatActivity() {
    // Metodo main comum serve para iniciar a operação da programação
    // O código AppCompatActivity() serve para o android pegar as informações iniciais para ele dar
    // início a operação do app, como informações onde estão as telas e qual é a tela de início,
    // quais são as informações basicas dessa tela e tambem oferece configurações basicas de funções
    // pré criadas para configurar o app

    private lateinit var prefs: SharedPreferences // Aqui é a parte inicial da criação de um banco
    // de dados, mas basicamente aqui esta sendo criado uma area para armazenamento de dados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Essa função on Create é a função interna e obrigatória para o início do projeto. Ela
        // configura a tela, infomação de clique, onde estão as pasta de auxílio ... a bixa é picona
        // ela faz tudo

        // APARTIR dessa linha a ação queo seu app vai tomar
        setContentView(R.layout.activity_main) // Aqui você esta importando a tela inicial para
        // efetivamente mostrar a tela inicial para o usuário, e poder manipular os objetos dentro
        // dessa tela
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_gererate)

        prefs = getSharedPreferences("db", Context.MODE_PRIVATE) // Aqui você cria um banco
        // de dados para consutar a informações dos antigos resultados, utilizando aquela areá que
        // você tinha reservado anteriormente
        val result = prefs.getString("result_db", null) // Lembrando que no lugar de
        // null você pode colocar alguma mensagem e isso ira fazer que quando o valor for null ele
        // ira mostrar a mensagem
//        if (result != null) {
//            txtResult.text = "Ultima aposta : $result"
//        }
        // Podemos usar uma outra função no lugar do if podemos utilizar
        result?.let {
            txtResult.text = "Ultima aposta : $it" // Isso ira ter o mesmo efeito do if
        } // É indiferente qual você utiliza porem sempre tente manter um padrão, não utilize
        // os dois no mesmo código pois isso pode fazer você acabar se confundido na hora de edita-ló ou conferi-ló

        // txtResult.text = "Teste" // Isso serve para ver se o campo colocado esta funcionando
        // Para texta o botão existe 3 metodos e o terceito é o mais tilizado e o mais inxuto
        // Opção 1 ---> XML
        // Vai no arquivo activity_main.xml e coloca a linha de codigo
        // android:onClick= "Nome_da_referencia"
        // Após isso crie uma função com esse nome que ira mostrar na fela de Log a infomação de
        // quando o botão foi clicado
        // Opção 2 ---> Variável que seja do tipo View.OnClickListener (interface)
//        btnGenerate.setOnClickListener(buttonClickListener)
        // Opção 3 ---> Bloco de código que será disparado pelo onClickListener
//        btnGenerate.setOnClickListener { Log.i("Teste", "Botão clicado!!!") }

        btnGenerate.setOnClickListener {
            val text = editText.text.toString()
            // LEMBRETE: Todos compos de texto do android é de tipo String, sem exeção!

            numberGenerator(text, txtResult)
        }
    }

    // Opção 1 ---> XML
//    fun Nome_da_referencia(view: View) { // view: View é a configuração padrão para botão aqui
//        // no android estudio
//        Log.i("Teste", "Botão clicado!!!") // Com isso vai fazer aparecer uma mensagem
//        // na tela de log toda vez que a palavra chave for acinada
//    }
    // Opção 2 ---> Variável que seja do tipo View.OnClickListener (interface)
//    val buttonClickListener = object : View.OnClickListener {
//        override fun onClick(v: View?) {
//            Log.i("Teste", "Botão clicado!!!")
//        }
//    }

    private fun numberGenerator(text: String, txtResult: TextView) {
//        txtResult.text = text // Teste para ver se a função está funcionando
        // Sempre pense o que o corno do usuário pode fazer para quebrar o seu código para você
        // fazer as funções adequadas... até ai tudo normal por aqui né... kkk T-T
        // Lista de coisas que podem dar errado:
        // 1 - Validar quando o campo é vazio
        // 2 - validar se o camopo informado é entre 6 e 15
//        if (text.isNotEmpty()) {
//            val qtd = text.toInt() // Converte para inteiro
//            if (qtd >= 6 && qtd <= 15) { // LEMBRETE: && significa e || significa ou
//                val numbers = mutableSetOf<Int>()
//                val random = Random()
//
//                while(true) {
//                    val number = random.nextInt(60)
//                    numbers.add(number + 1)
//
//                    if (numbers.size == qtd) {
//                        break
//                    }
//                }
//                txtResult.text = numbers.joinToString(" - ")
//            } else{
//                Toast.makeText(this, "Informe um número entre 6 a 15",
//                    Toast.LENGTH_LONG).show()
//            }
//        } else { // DICA: Sempre valide as falhas antes de fazer o sucesso
//            Toast.makeText(this, "Informe um número entre 6 a 15",
//                Toast.LENGTH_LONG).show() // Isso faz aparecer uma mensagem caso entre nesse else
//        }

        // Podemos fazer com que essa função fique em formato mais inxota removendo os else
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um número entre 6 a 15",
                Toast.LENGTH_LONG).show()
            return
        }
        val qtd = text.toInt()
        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Informe um número entre 6 a 15",
                Toast.LENGTH_LONG).show()
            return
        }
        val numbers = mutableSetOf<Int>()
        val random = Random()
        while(true) {
            val number = random.nextInt(60)
            numbers.add(number + 1)
            if (numbers.size == qtd) {
                break
            }
        }
        txtResult.text = numbers.joinToString(" - ")

        val editor = prefs.edit() // Com o .edit nos trocamos o tipo de variável do banco de dados
        // deixando essa variavel
        editor.putString("result_db", txtResult.text.toString()) // Aqui nos estamos trocando as
        // informações do banco
        editor.apply() // Aqui e de fato a sauvação da informação para banco de dados. Estamos
        // mudando o tipo denovo da variável, tirarndo do tipo .edit e colocando no
        // tipo SharedPreferences
        // LEMBRETE: Presisamos fazer esse tipo de mudança para salvar porque o tipo
        // SharedPreferences é um tipo de variável imutavel
        // INFORMAÇÃO ACADÊMICA
        // Nesse tipo de banco de dados existe dois tipos de salvamento
        // commit --> Salvar de forma sicrona (BLOQUEA a intercace); Informa se teve sucesso ou não
        // apply --> Salvar de forma assicrona (NÃO Bloquea a intercace); NÃO informa se teve
        //           sucesso ou não
//        val saved = editor.commit() // Testando ara ver se esta Salvando
//        Log.i("Teste", "Foi salvo : $saved")

        // Para não ter que ficar chamado o comando principal como o editor podemos utilizar o
        // apply que ira incurtar o chamento para nos
//        prefs.edit().apply {
//            putString("result", txtResult.text.toString())
//            putBoolean("chave", true)
//            putFloat("chaveX2", 10.0f)
//            apply()
//        }
    }
}