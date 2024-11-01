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
}

class Button {
    var text: String = ""
    var color: String = ""
}

