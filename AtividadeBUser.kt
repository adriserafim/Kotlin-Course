class User {
    var name: String = ""
    val userCPF = CPF(123456)

    // Responsabilidade
    fun printUpperCase() {
        println(name.uppercase())
    }

    fun updateName(newName: String) {
        name = newName
    }

    fun printCPF() {
        println(userCPF)
        //gaga = "Eu não consigo mudar essa variavel porque ela é privada"
    }
}