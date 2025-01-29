package co.tiagoaguiar.fitnesstracker

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ItemList(
    val id: Int,
    val textStringType: String,
    val textStringDate: Date,
    val textStringResultCalc: String
) {
    fun getFormattedData(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
        return sdf.format(textStringDate)
    }
    val textStringResultCalcCut = textStringResultCalc.substringBefore(".") + "." + textStringResultCalc.substringAfter(".").take(2)
}
