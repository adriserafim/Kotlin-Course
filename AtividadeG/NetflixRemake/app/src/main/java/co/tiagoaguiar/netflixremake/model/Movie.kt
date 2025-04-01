package co.tiagoaguiar.netflixremake.model

import androidx.annotation.DrawableRes

// Vamos alterar a coleta de informações de offline para online
//data class Movie(@DrawableRes val converUrl: Int)
data class Movie(
    val id: Int,
    val coverUrl: String,
    val title: String = "",
    val desc: String = "",
    val cast: String = ""
)
