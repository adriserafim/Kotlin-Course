package co.tiagoaguiar.fitnesstracker.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Calc::class], version = 1, exportSchema = true)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calcDao() : CalcDao

    companion object {
        // Isso ira fazer com que nos sempre utilizamos o mesmo banco de dado, porque caso não
        // fizermos isso ele irá criar sempre um banco de dados novo sempre que for chamado.

        private var INSTANCE: AppDatabase? = null // Com isso nos criamos uma unica banco de dados,
        // como ele vai ser uma constate por forma de convenção de programação nos colocamos ele com
        // todas as letras em maiúsculo.

        fun getDatabase(context: Context) : AppDatabase {
            return if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "fitness_tracker"
                    ).build()
                }
                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
            // Essa é a função que faz com que se não tiver nenhum banco de dados criado eles criam
            // um banco de dados, mas se tiver eles utilizam o banco já criado.
        }
    }

    // Com o @Database(entities = [Exemplo::class], version = 1) nos falamos para o kotlin que essa
    // class é uma Class do Banco de dados que basicamente é uma classe que gerencia todos os bancos
    // de dados dentro da app.
}