class AtividadeBPlus constructor(cod1: Int, cod2: Boolean, cod3: String){

    companion object{ // Com essa cofiguração eu vou conseguir fazer variáveis que seja visiveis em todos as classes
        var count = 0

        fun resetCount(){
            count = 0
        }
    }

    init {
        println("Eu vou primerio")
        count ++
        println(count)
    }

    constructor(cod1: Int) : this(cod1, cod2 = false, cod3 = "Fulano") {
        println("Segundo contrutor")
    }
    constructor(): this(0) {
        println("Terceiro contrutor")
    }

    private var gaga = "Primeiro contrutor"
}