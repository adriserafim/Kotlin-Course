package co.tiagoaguiar.fitnesstracker

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class TmbActivity : AppCompatActivity() {

    private lateinit var  lifestyle: AutoCompleteTextView

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmb)

        lifestyle = findViewById(R.id.auto_lifestyle)
        val items = resources.getStringArray(R.array.tmb_lifestyle)
        lifestyle.setText(items.first()) // Isso faz com que uma preseleção já esteja selecionada. A
        // ordem é importante ele tem que esta antes do adapiter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        lifestyle.setAdapter(adapter)

    }
}