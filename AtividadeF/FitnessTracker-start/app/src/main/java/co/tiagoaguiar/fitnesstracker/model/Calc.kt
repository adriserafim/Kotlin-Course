package co.tiagoaguiar.fitnesstracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Calc(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "res") val res: Double,
    @ColumnInfo(name = "created_date") val createdDate: Date = Date(),
)
// Com o @Entity eu informo ao kotlin que essa class vai servir com uma class entidades.
// E depois disso eu posso informar a o kotlin as sua colunas de armazenamento como:
// - @PrimaryKey vai criar uma númeração única para o dado icrementado no banco de dados:
//      - Caso você coloque (autoGenerate = true) ele ira fazer essa função atomaticamente de por
//       identificação na linha e ir de forma crescente a identificação;
// - @ColumnInfo Ele ira colocar uma coluna com esse dado e ira encrementar o dado conforme for
// pedido utilizando a identificação unica como referência:
//      - Você pode colocar o nome na coluna com: (name = "exe") também para identificação e
//      controle. OBS: Por padão não verbal da sociedade programadora eles sempre deixão o nome das
//      colunas em letra minúscula.
