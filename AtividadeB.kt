fun main(args: Array<String>) {
    // Molde (Template)
    // class (molde responsavel porcriar N objetos (proriedade | comportamentos))
    // Objeto é instancia (a criação) a partir daquele molde, se o molde mudar ele muda

    val userA = User()
    val userB = User()

    userA.name = "Tiago"
    userB.name = "Bruce"

    userA.printUpperCase()
    userB.printUpperCase()

    userA.updateName("Thiago")
    userA.printUpperCase()
    userA.printCPF()

    val buttonSuccess = Button()
    buttonSuccess.text = "Sucesso"
    buttonSuccess.color = "00FF00"

    val buttonCancel = Button()
    buttonCancel.text = "Cancelar"
    buttonCancel.color = "FF0000"

    val des1 = AtividadeBPlus(33)
    val des2 = AtividadeBPlus(23)
    AtividadeBPlus.resetCount()
    val des3 = AtividadeBPlus()


    val userC = "Tiago"
    println(AtividadeBObj.IDUser)
    login(userC, userC)
    println(AtividadeBObj.IDname)
    println(AtividadeBObj.IDUser)

    val kikoLoureiro = Musician()
    kikoLoureiro.desc()

    val guitar = kikoLoureiro.guitar()
    guitar.desc()

    val sax = Musician.Sax()
    sax.desc()

    println(CreditCard.MASTER) // Aqui você traz o nome da váriavel
    println(CreditCard.MASTER.ordinal) // Aqui você traz a númeração da váriavel
    val creditCardAPIName = "amex"
    println(CreditCard.valueOf(creditCardAPIName.uppercase()))
    val card = CreditCard.valueOf(creditCardAPIName.uppercase())
    /*
    if (card == CreditCard.VISA) {
        println("Da um desconto!")
    } else {
        println("Avisa o usuario que o cartão VISA tem desconto")
        println("Você esta usando o cartão ${card.label}")
    }
    */
    // Vou usar O When para subistituir o if
    /*
    when {
        card == CreditCard.VISA -> {
            println("Da um desconto!")
        }
        else -> {
            println("Avisa o usuario que o cartão VISA tem desconto")
            println("Você esta usando o cartão ${card.label}")
        }
    }
     */
    when(card) {
        CreditCard.VISA -> println("Da um desconto!")
        CreditCard.MASTER -> println("Da um desconto!")
        else -> {
            println("Aviso o usuario com o cartões Visa e MasterCard tem desconto")
            println("Você esta usando o cartão ${card.label}")
        }

    }

    /*
    //var discount: String = "" // Para tornar o código mais enxuto não presisa fazer essa linha de código
    val discount = if (card == CreditCard.VISA) { // Você pode colocar a váriavel para ser o retorno da condição
        println("Entrei no if") // Aqui você pode colocar a logica dentro do  bloco
        "Desconto de 20%" // A ultima linha é o retorno "return" da condição
    } else if (card == CreditCard.MASTER){
        "Desconto de 30%"
    } else {
        "Desconto não aplicado"
    }
     */
    val discount = when (card) {
        CreditCard.VISA -> "Desconto de 20%"
        CreditCard.MASTER -> "Desconto de 30%"
        else -> "Desconto não aplicado"
    }
    println(discount)

    val exp1 = Exp(Argm2 = "Item 2", Argm1 = "Item 1", Argm3 = "Item 3") // Isso se chama destruturação, e ela só
    // funciona com a data class por conta da sua lógica de funcionamento
    val (Argm1, Argm3, Argm2) = exp1 // A destruturação sempre segue a ordem da sua linha de condição
    println("A seguencia ficou assim $Argm1, $Argm2, $Argm3") // Veja que o Item 2 e o Item 3 ficaram invertidos, por
    // conta da hora que eu fui falara as condições eu segui a ordem de (Argm1, Argm3, Argm2)

    val exp2 = exp1.copy(Argm3 = "Item 4") // Com esse recurso eu consigo codiar a váriavel, nos podemos alterar so uma
    // das propriedades ou da para alterar mais parametros
    println(exp1)
    println(exp2)

    val Coordinate = Pair(5,10) // Utilizando o Pair fazemos um data class simples com dois atributos
    val SecWayToDoThis = 42 to "Tiago" // Outro jeito de fazer isso é utilizando o to
    println(Coordinate.first)
    println(Coordinate.second)
    println(SecWayToDoThis.first)
    println(SecWayToDoThis.second)
    val Coordinate2 = Triple(5,10,6) // Utilizando o Pair fazemos um data class simples com três
    // atributos
    println(Coordinate2.first)
    println(Coordinate2.second)
    println(Coordinate2.third)

    val p = Professor("Girafales", "Rua A.")
    println(p.description())
    val a = Student(123456789, "Adriano", "Rua B.")
    println(a.description())
    println(a.description2())

    val d = Dad("Pai", "Rua C.")
    println(d.description())
    val s = Son( "Filhho", "Rua D.")
    println(s.description())
    val f = Lack("Faluta")
    f.sharpen()
    val g = Guitar("Fender")
    g.sharpen()
}

class Button {
    var text: String = ""
    var color: String = ""
}

fun login(user: String, u2ser: String){
    AtividadeBObj.IDname = u2ser
    AtividadeBObj.IDUser = user
}

class Musician {
    var style: String = "Rock"
    fun desc() = println("Meu estilo é $style")

    inner class guitar {
        var strings = 6
        fun desc() = println("Tocando uma guitarra com $strings cordas. E o estilo de musica é $style")
    }

    class Sax { // classes aninhadas
        var family = "saxofone soprano"
        fun desc() = println("familias $family")
    }
}

enum class CreditCard(val label: String) { // Isso vai fazer ele enumerar os item para você utilizar em lógicas
    VISA("Visa"),
    MASTER("MasterCard"),
    ELO("Elo"),
    AMEX("American Express")
}

// data class é um tipo de clase que o ponto de referencia não é valores ou nomes mas sim o armazenamento interno
data class Exp(var Argm1: String, var Argm2: String, var Argm3: String) {
    fun description(): String = "Argumento 1"
}

// Herança de class
open class Person(var name: String, var address: String){
    protected var isLibrary = false // Protege a varialem deixando somente o pai e os filhos mudarem o valor
    fun description() = "Meu nome é $name e meu endereço é $address, meu acesso a biblioteca é $isLibrary"
}
class Professor(name: String, address: String) : Person(name, address) {
    init {
        isLibrary = true
    }
}
class Student(var registrationID: Int, name: String,address: String) : Person(name, address){
    fun description2() = "Meu nome é $name, meu número de registo é $registrationID e meu enderço é $address, meu " +
            "acesso a biblioteca é $isLibrary"
}

abstract class Grampa(var name: String, var address: String){ // Isso faz como que a class fique abristrato, e é como
    // se o vovô morreu mas a erança dele ainda esta viva para pus decencentes
    fun description() = "Meu nome é $name e meu endereço é $address"
}
class Dad(name: String, address: String) : Grampa(name, address) {
}
class Son(name: String, address: String) : Grampa(name, address) {
}

abstract class Instrument(var nome: String) {
    abstract fun sharpen() // Já aqui nos colocamos herança especifica nos objetos internos a class
}
class Guitar(nome: String) : Instrument(nome){
    override fun sharpen(){ // Todas as classe filhas obrigatoriamente tem que tem a herança e para identificar a
        // codificação da herança nos temos a codificação override
        println("Afinação em E(Mi)")
    }
}
class Lack(nome: String) : Instrument(nome){
    override fun sharpen(){
        println("Afinação em C(Dó)")
    }
}