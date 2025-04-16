package co.tiagoaguiar.course.instagram.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
  // Agora que aprendemos as maneira mais arcaicas de como fazer o projeto e aprendemos o conceito
  // por traz da codificações o professor vai começar a passar uma aprendizado que sera mais para as
  // ferramentas atualizadas do programação moderna.

  // Iremos começar com a funsão do findViewById<TextInputEditText>(R.id. ... ) -> Sempre que
  // vamos inflar uma tela utilizamos esse recurso sendo assim essa função foi modenizada e
  // facilitado usando a ferramenta:
//  buildFeatures {
//    viewBinding true
//  }
  // No app.build.gradle nos podemos utilizar a função binding, essa função cria arquivos tepararios
  // de ligação entre os XML com os arquivos kotlin operando a assim a função do
  // findViewById<TextInputEditText>(R.id. ... )
  private lateinit var binding: ActivityLoginBinding // Para aciona-la é só criar uma variavel com
  // a tipo com o nome igual a do arquivo XML so que em camelcase e com a utima palavra sendo Binding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding =
      ActivityLoginBinding.inflate(layoutInflater) // TODO: E para acioonala basta apenas chmala
//    setContentView(R.layout.activity_login)
    setContentView(binding.root) // Apatir desse momento que atrelamos o XML com o arquivo kotlin,
    // para se referir a um item do arquivo XML é so colocar o nome da variável atrelado o XML e
    // colocar o nome de id atrelado.

//    val editTextEmail = findViewById<TextInputEditText>(R.id.login_edit_email)
//    val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_password)

//    editTextEmail.addTextChangedListener(watcher)
//    editTextPassword.addTextChangedListener(watcher)
    binding.loginEditEmail.addTextChangedListener(watcher)
    binding.loginEditPassword.addTextChangedListener(watcher)

//    val buttonEnter = findViewById<LoadingButton>(R.id.login_btn_enter)
//    buttonEnter.setOnClickListener {
//      buttonEnter.showProgress(true)
//
//      findViewById<TextInputLayout>(R.id.login_edit_email_input)
//        .error="Esse e-mail é invalido"
//
//      findViewById<TextInputLayout>(R.id.login_edit_password_input)
//        .error="Senha incorreta"
//
//      Handler (Looper.getMainLooper()).postDelayed({
//        buttonEnter.showProgress(false)
//      }, 2000)
//    }
    with(binding) { // Podemos usar o with assim tirando a nessecidade de ficar fazendo binding.
      loginBtnEnter.setOnClickListener {
        loginBtnEnter.showProgress(true)
        loginEditEmailInput.error = "Esse e-mail é invalido"
        loginEditPasswordInput.error = "Senha incorreta"

        Handler(Looper.getMainLooper()).postDelayed({
          loginBtnEnter.showProgress(false)
        }, 2000)
      }
    }
  }

  private val watcher = object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//      findViewById<LoadingButton>(R.id.login_btn_enter).isEnabled = s.toString().isNotEmpty()
      binding.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
    }

    override fun afterTextChanged(s: Editable?) {
    }
  }
}