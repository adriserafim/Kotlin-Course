package co.tiagoaguiar.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// Aqui nos vamos fazer uma class para o adapter para poder separa mais o código, para organizar
// melhor e deixar mais facil para edições futuras
class MainAdapter : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return  MovieViewHolder(view)
    } // O layoutInflater. não pode ser utilizado aqui pois essa ferramenta so existe na função
    // AppCompatActivity e como nos não estamos lá não podemos utiliza-lá

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}