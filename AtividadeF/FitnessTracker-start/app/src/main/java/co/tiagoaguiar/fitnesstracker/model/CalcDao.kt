package co.tiagoaguiar.fitnesstracker.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalcDao {
    @Insert
    fun insert(calc: Calc)

    @Query("SELECT * FROM Calc WHERE type = :type")
    fun getRegisterByType(type: String) : List<Calc>

    // Com o @Dao nos informamos para o kotlin que essa interfeice vai ter como funsão ser a class
    // DAO. Essa class tem que ser inteface. Porque a class como interface da liberdade para ao
    // kotlin de fazer todas as programações padrões automaticamente sem ter na necessitarmos
    // configura-lo, apenas precisamos informar quais são as informações que queremos e o que
    // queremos.
    // Dentro daqui podemos dar as seguintes intruções:
    // - @Insert -> Para inserir uma coluna e onde armazenala;
    // - @Delete -> Para deletar uma coluna ou linha e onde efetuar esse recurso;
    // - @Query -> Buscar informação e onde buscar a informação;
    // - @Update -> Atualizar a informação e onde atualizar essa informação.
}