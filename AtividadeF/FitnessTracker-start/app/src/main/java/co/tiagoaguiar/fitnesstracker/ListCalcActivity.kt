package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.fitnesstracker.model.Calc

private lateinit var rvList: RecyclerView

class ListCalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_calc)

        rvList = findViewById(R.id.rv_list)
        val type = intent?.extras?.getString("type") ?: throw IllegalStateException("Type not found")

        Thread {
            val app = application as App
            val dao = app.db.calcDao()
            val response = dao.getRegisterByType(type)

            val itemList = response.map {
                ItemList(
                    id = it.id,
                    textStringType = it.type,
                    textStringDate = it.createdDate.toString(),
                    textStringResultCalc = it.res.toString()
                )
            }

            runOnUiThread {
                //Log.i("Teste", "resposta: $response")
                val reversedItemList = itemList.reversed() // Revertendo a lista
                val adapter = ListAdapter(itemList)
                rvList.adapter = adapter
                rvList.layoutManager =  LinearLayoutManager(this)
            }
        } .start()
    }

    private inner class ListAdapter(private val items: List<ItemList>) : RecyclerView.Adapter<ListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val view = layoutInflater.inflate(R.layout.list_calc, parent, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val currentItem = items[position]
            holder.bind(currentItem)
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    private class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val typeText: TextView = view.findViewById(R.id.type_text)
        private val dateText: TextView = view.findViewById(R.id.date_text)
        private val resultText: TextView = view.findViewById(R.id.result_text)

        fun bind(item: ItemList) {
            typeText.text = item.textStringType
            dateText.text = item.textStringDate
            resultText.text = item.textStringResultCalc
        }
    }
}