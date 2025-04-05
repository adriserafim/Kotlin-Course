package co.tiagoaguiar.course.instagram.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.course.instagram.R

class CustomDialog(context: Context) : Dialog(context) {
    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        dialogLinearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(listener: View.OnClickListener, vararg texts:Int) {
        txtButtons = Array(texts.size) {
            TextView(context)
        }
        texts.forEachIndexed { index, txtId ->
            txtButtons[index].setText(txtId)
        }
    }

    override fun show() {
        super.show()

        for(textView in txtButtons) {
            dialogLinearLayout.addView(textView)
        }
    }
}