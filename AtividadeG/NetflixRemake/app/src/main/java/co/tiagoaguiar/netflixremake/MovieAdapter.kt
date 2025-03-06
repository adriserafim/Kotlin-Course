package co.tiagoaguiar.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Movie

// Aqui nos vamos fazer uma class para o adapter para poder separa mais o código, para organizar
// melhor e deixar mais facil para edições futuras
class MovieAdapter (
    private val movies: List<Movie>,
    @LayoutRes private val layoutId: Int
    ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return  MovieViewHolder(view)
    } // O layoutInflater. não pode ser utilizado aqui pois essa ferramenta so existe na função
    // AppCompatActivity e como nos não estamos lá não podemos utiliza-lá

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val imageCover: ImageView = itemView.findViewById(R.id.img_conver)

            // TODO: Aqui vai ser trocado por uma URL que vira do servidor
            // imageCover.setImageResource(movie.converUrl)
        }
    }
}