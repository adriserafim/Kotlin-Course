package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private lateinit var btnImc: LinearLayout
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Inf: para armazenamento de dados pequenos nos podemos
        // utilizar o savedInstanceState, mas para amazenamentos maiores e para de fato ter um fanco
        // de dados nos podemos utilizar outras ferramentas, nosso mentor vai ensinar dois metodos
        // de armazenamento de dados sendo ela uma off-line e outra on-line:
        //  - Para criar bancos de dados off-line iremos utilizar o método room, que é uma
        //  biblioteca que faz uma especie de ponte para nos com o amazenamento de dados em SQLite.
        //  Para criar o banco de dado nos necessitaremos uma estrutura com os seguintes itens:
        //  1 - Class do Banco de dados;
        //  2 - Class de Entidades (Local de armazenamento da tabela);
        //  3 - Class DAO (A class resposavel pela comunicação com o sistema).
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_calculate_24,
                textStringId = R.string.label_imc,
                color = Color.BLUE
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_content_paste_24,
                textStringId = R.string.label_tmb,
                color = Color.YELLOW
            )
        )

//        // 1º Método - Para escutar eventos de click - Implementar interface
//        // Imprementando metodo de RecyclerView
//        val adapter = MainAdapter(mainItems, onItemClickListener = this) // Para esse metodo
//        // funcionar a criação de uma interface tem que ser feita e chamada pela funsão
//        rvMain = findViewById(R.id.rv_main)
//        rvMain.adapter = adapter
////        rvMain.layoutManager = LinearLayoutManager(this) // Isso faz com que o app fique em
//    // formato de linha
//        rvMain.layoutManager = GridLayoutManager(this, 2) // Isso faz com que fique
//    // em formato de grid

//        // 2º Método - Para escutar eventos de click - Implementando a interface via objeto anonimo
//        val adapter = MainAdapter(mainItems, object : OnItemClickListener {
//            override fun onClick(id: Int) {
//                when(id) {
//                    1 -> {
//                        val intent = Intent(this@MainActivity, ImcActivity::class.java)
//                        startActivity(intent)
//                    }
//                    2 -> {
//                        // abrir uma outra activity
//                    }
//                }
//            }
//        }) // Já para esse modelo a interfase é chamada direta pela activity
//        rvMain = findViewById(R.id.rv_main)
//        rvMain.adapter = adapter
//        rvMain.layoutManager = GridLayoutManager(this, 2)

        // 3º Método - Para escutar eventos de click - Implementando a interface via functions
        // -- Método mais profisonal --
        val adapter = MainAdapter(mainItems) { id ->
            when (id) {
                1 -> {
                    val intent = Intent(this@MainActivity, ImcActivity::class.java)
                    startActivity(intent)
                }

                2 -> {
                    val intent = Intent(this@MainActivity, TmbActivity::class.java)
                    startActivity(intent)
                }
            }
        } // Já para metodo o evento de toque foi chamado totalmente pelo configuração Kotlin
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)

//        btnImc = findViewById(R.id.btn_imc)
//        btnImc.setOnClickListener{
//            // AQUI ficara uma a códificação para ir para proxima tela
//            val i = Intent(this, ImcActivity::class.java)
//            startActivity(i)
//        }
    }

    // 1º Método - Para escutar eventos de click - Implementar interface
//    override fun onClick(id: Int) {
//        when(id) {
//            1 -> {
//                val intent = Intent(this, ImcActivity::class.java)
//                startActivity(intent)
//            }
//            2 -> {
//                // abrir uma outra activity
//            }
//        }
//    }

//    // 1º e 2º Método - Para escutar eventos de click
//    private inner class MainAdapter(
//        private val mainItems: List<MainItem>,
//        private val onItemClickListener: OnItemClickListener
//        ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
//        // 1 - Qual é o layout XML da celula especifica (item)
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
//            return MainViewHolder(view)
//        }
//
//        // 2 - Dispara toda vez que houver uma rolagem na tela e for necessario trocar o conteudo
//        // da celula
//        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//            val itemCurrent = mainItems[position]
//            holder.bind(itemCurrent)
//        }
//
//        // 3 - Informa quantas celulas essa listagem terá
//        override fun getItemCount(): Int {
//            return mainItems.size
//        }
//
//        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//            fun bind(item: MainItem) {
//                val img: ImageView = itemView.findViewById(R.id.item_img_icon)
//                val name: TextView = itemView.findViewById(R.id.item_txt_name)
//                val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)
//
//                img.setImageResource(item.drawableId)
//                name.setText(item.textStringId)
//                container.setBackgroundColor(item.color)
//
//                container.setOnClickListener {
//                onItemClickListener.onClick(item.id) // Aqui o onItemClickListener é uma
//                // referência a funsão
//                }
//            }
//        }
//    }

    // 3º Método - Para escutar eventos de click - Implementando a interface via functions
    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
        private val onItemClickListener: (Int) -> Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(item: MainItem) {
                val img: ImageView = itemView.findViewById(R.id.item_img_icon)
                val name: TextView = itemView.findViewById(R.id.item_txt_name)
                val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)

                img.setImageResource(item.drawableId)
                name.setText(item.textStringId)
                container.setBackgroundColor(item.color)

                container.setOnClickListener {
                    onItemClickListener.invoke(item.id) // Aqui o onItemClickListener é uma
                // referência a interface
                }
            }
        }
    }
}