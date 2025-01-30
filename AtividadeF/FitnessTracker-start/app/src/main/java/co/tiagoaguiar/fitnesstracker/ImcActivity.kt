package co.tiagoaguiar.fitnesstracker

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import co.tiagoaguiar.fitnesstracker.model.Calc

class ImcActivity : AppCompatActivity()  {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        var btnSend: Button = findViewById(R.id.btn_imc_send)
        btnSend.setOnClickListener{
            if (!validate()) {
                Toast.makeText(this, R.string.fields_messagens, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()

            val result = calculateImc(weight,height)
            Log.d("Teste", "resultado: $result")

            val imcResponseId = imcResponse(result)
//            Toast.makeText(this, imcResponseId, Toast.LENGTH_SHORT).show()

//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle(getString(R.string.imc_response, result))
//            dialog.setMessage(imcResponseId)
//            dialog.setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface?, which: Int) {
//                    // Aqui vai rodar depois do click
//                }
//            })
//            val d = dialog.create()
//            d.show()
            // Nos podemos exotar essa linhas de código e deixar o nosso código mais profissonal
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.imc_response, result))
                .setMessage(imcResponseId)
                .setPositiveButton(android.R.string.ok) {dialog,which ->
                // Aqui vai rodar depois do click
            }
                .setNegativeButton(R.string.save) { dialog,which ->
                    Thread {
                        val app = application as App
                        val dao = app.db.calcDao()
                        dao.insert(Calc(type = "imc", res = result))
                        runOnUiThread {
//                            Toast.makeText(this@ImcActivity,R.string.saved, Toast.LENGTH_LONG).show()
                            openListActicity()
                        }
                    } .start()
                }
                .create()
                .show()

            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_search) {
            openListActicity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openListActicity() {
        val intent = Intent(this@ImcActivity, ListCalcActivity::class.java)
        intent.putExtra("type", "imc")
        startActivity(intent)
    }

    private fun validate(): Boolean{
        // Não pode inserir valores nulos / vazio
        // Não pode inserir / começar com 0 (ZERO)

        // 1° Opção: Usando if e else (Mais simples, e o que mostra que você é um novato)
//        if (editWeight.text.toString().isNotEmpty()
//            && editHeight.text.toString().isNotEmpty()
//            && !editWeight.text.toString().startsWith("0")
//            && !editHeight.text.toString().startsWith("0")) {
//            return true
//        } else {
//            return false
//        }

        // 2° Opção: Usar somente return para simular o if/else
//        if (editWeight.text.toString().isNotEmpty()
//            && editHeight.text.toString().isNotEmpty()
//            && !editWeight.text.toString().startsWith("0")
//            && !editHeight.text.toString().startsWith("0")) {
//            return true
//        }
//        return false
        // A idéia por traz disso é que se a função não entrar no if ela vai continuar a linha de
        // código de tudo qualquer jeito. Esse estilo e utilizado porem não mostra total dóminio...

        // 3° Opção: Retornar direto o que for verdadeiro
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))
        // Desse jeito ele analisa a condição e coloca entre os () o resultado dessa condição, esse
        // é o metodo que mostra mais maestria na programação, pois ele é o metodo mais dificil de
        // ser enchergado e mais inchuto
    }

    private fun calculateImc(weight: Int, height: Int): Double {
        // Formula: peso(Kg) / (altura(m) * altura(m))
        return weight / ((height / 100.0) * (height / 100.0))
    }

    @StringRes // Fazer isso informa para pessoa que for olhar o seu código que ela tem que prestar
    // atenção na informação de resutado dessas funsão e colocar o valor errado pode resultar em
    // bugs. Também informa o tipo de informação esperada da funsão
    private fun imcResponse(imc: Double): Int {
//        if (imc < 14.0) {
//            return R.string.imc_extreme_low_weight
//        } else if (imc < 15.0) {
//            return R.string.imc_severely_low_weight
//        } else if (imc < 16.0) {
//            return R.string.imc_very_low_weight
//        } else if (imc < 18.5) {
//            return R.string.imc_low_weight
//        } else if (imc < 25.8) {
//            return R.string.imc_normal
//        } else if (imc < 30.0) {
//            return R.string.imc_high_weight
//        } else if (imc < 35.0) {
//            return R.string.imc_so_high_weight
//        } else if (imc < 40.0) {
//            return R.string.imc_severely_high_weight
//        } else {
//            return R.string.imc_extreme_high_weight
//        } // Isso funciona, mas não é o metodo mais fácil e nem o mais profissonal de se fazer,
        // dito isso mostrarei em abaixo uma forma mais exota de se fazer essas linhas de código
//        when {
//            imc < 14.0 -> return R.string.imc_extreme_low_weight
//            imc < 25.8 -> return R.string.imc_normal
//            imc < 40.0 -> return R.string.imc_severely_high_weight
//            else -> R.string.imc_extreme_high_weight
//        } // Como todas as linha tem o return nos podemos exotar mais as linha de código fazendo
        // isso:
        return when {
            imc < 14.0 -> R.string.imc_extreme_low_weight
            imc < 15.0 -> R.string.imc_severely_low_weight
            imc < 16.0 -> R.string.imc_very_low_weight
            imc < 18.5 -> R.string.imc_low_weight
            imc < 25.8 -> R.string.imc_normal
            imc < 30.0 -> R.string.imc_high_weight
            imc < 35.0 -> R.string.imc_so_high_weight
            imc < 40.0 -> R.string.imc_severely_high_weight
            else -> R.string.imc_extreme_high_weight
        }
    }
}