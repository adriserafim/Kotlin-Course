package co.tiagoaguiar.course.instagram.register.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.common.view.CustomDialog
import co.tiagoaguiar.course.instagram.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {
    private var binding: FragmentRegisterPhotoBinding? = null

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_register_photo, container,false)
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterPhotoBinding.bind(view)
        val customDialog = CustomDialog(requireContext())
        customDialog.setTitle(R.string.app_name) // Aqui nos conseguimos trocar o texto do titulo
        // do customDialog
        customDialog.addButton(R.string.photo, R.string.gallery) {
//            Log.i("Teste", (it as TextView).text.toString())
            when (it.id) {
                R.string.photo -> {
                    // Faz alguma coisa
                    Log.i("Teste", "Foto")
                }
                R.string.gallery -> {
                    // Faz outra coisa
                    Log.i("Teste", "Galeria")
                }
            }
        }

        // Foi troca o Lisiner de lugar causando um erro, pois tem que mater a seguencia do chamdo,
        // mas com isso faz com que o codigo fique mais fácil de ler e deixar mais profissional
//        customDialog.addButton({
//            Log.i("Teste", (it as TextView).text.toString())
//        }, R.string.photo, R.string.gallery)
        customDialog.show()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}