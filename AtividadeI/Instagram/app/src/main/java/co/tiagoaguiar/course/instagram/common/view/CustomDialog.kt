package co.tiagoaguiar.course.instagram.common.view

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.databinding.DialogCustomBinding

class CustomDialog(context: Context) : Dialog(context) {
    private lateinit var binding: DialogCustomBinding
//    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>
//    private lateinit var txtTitle: TextView
    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.dialog_custom)
//        dialogLinearLayout = findViewById(R.id.dialog_container)
//        txtTitle = findViewById(R.id.dialog_title)
        binding = DialogCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setTitle (titleId: Int) {
        this.titleId = titleId
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun addButton(vararg texts:Int, listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context).apply {
                setText(texts[it])
                setTextColor(context.getColor(R.color.gray_text))
                textSize = 16f
//                setPadding(30,50,30,50)
//                setOnClickListener(listener) // Colocar o Listener aqui vai facilitar a leitura,
            //                mas pode dificultar no designer
            }
        }
        texts.forEachIndexed { index, txtId ->
            txtButtons[index].id = txtId
            txtButtons[index].setText(txtId)
            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()

        titleId?.let {
//            txtTitle.setText(it)
            binding.dialogTitle.setText(it)
        }

        for(textView in txtButtons) {
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30, 50, 30, 50)
//            dialogLinearLayout.addView(textView, layoutParams)
            binding.dialogContainer.addView(textView, layoutParams)
        }
    }
}