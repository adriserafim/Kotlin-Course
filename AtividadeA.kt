fun main() {
    println("Hello Word") // Como padrão println server para mostrar na tela de execução alguma informação "output"

    var product = "iMac" // var é o comando para criar uma variável
    println(product) // Como pode ser visto aqui a infomação contida na variável

    product = "iPhone" // Aqui eu estou subescrevendo a informação da variável
    println(product) // Como pode ser visto aqui a variável mudou de infomação

    //var product = "Android" // NÃO pode ser feito isso, isso irá dar uma erro de compilação, pois a variável product já foi criada

    val PI = 3.14 // val é o comando para criar uma variável imutável
    //PI = 2.35 // Sendo aasim caso você faça uma ação para tentar muda-lá o seu programa irá dar um erro de compilação

    var price = 31 // Para colocar valores númerico não precisa colocar o valor entre "", somente variaveis de texto precisão estar entre ""
    println(price)

    // Quando você colocar // na linha de código tudo que você escreve depois dessas barra não são intepretadas pelo código e elas
    // servem para você DOCUMENTAR, REFERENCIAR, FAZER NOTAS sobre o código que você quer referir. Isso é muito importante para organização do seu arquivo

    // TODO: Terminar os códigos para zxy // Detendendo do que você escreve a informação pode mudar de cor

    println(product::class) // Quando nos colocamos os ::class na função print você vai ter um output de informação
    println(PI::class) // A infomação que o programa ira te dar nesse caso é que é o tido de variável que é essa que você informou
    println(price::class) // Existe varios tipos de variável as mais comuns são double, String, int

    var reminder = "F23" // Quando você utiliza a função var você está deixando o computador escolher automaticamente que tipo de variável ele irá utilizar
    // Com isso nem sempre o comutador irá fazer a melhor escolha ou a ecolha que você deseja.

    val number1: Int = 23 // Sé nos quisermos podemos definir na programação qual é o tipo de variável que nos queremos que
    val text: String = "teste 1" // a variável fique.
    val number2: Double = 23.5 // Existem varios tipos de tipos de variável.

    // Quando você não define o tipo da variável ela é do TIPOS INFERIDO
    // Esses tipos como double, String e int são chamados de TIPOS PRIMITIVOS
    // Abaixo veja algumas outras tipos de tipos primitivos e suas limitasoes

    val byte: Byte = 8 // Ele consegue armazenar até 8-bit de espaço númerico
    val shout: Short = 16 // Ele conseque armazenar até 16-bit de espaço númerico
    val number3: Int = 31 // Ele consegue armazenar até 32-bit de espaço númerico (Usaremos ele 99% do tempo)
    val long1: Long = 192 // Ele consegue armazenar até 64-bit de espaço númerico

    val float1: Float = 31.99f // Ele consegue armazenar até 32-bit de espaço númerico com ponto flutuante "Número quebrado" (É obrigatorio utilizar o f no final)
    val double: Double = 31.99 // Ele consegue armazenar até 64-bit de espaço númerico com ponto flutuante

    val long2= 192L // Para facilitar nos podemos simplificar e não ter que escrever o tipo na frente você tambem pode usar essa forma para definir o tipo
    val float2= 31.99f // Long e Float utilizando um L ou um f na frente de uma definição de variável
    println(long2::class)
    println(float2::class)

    val string: String = "Text" // O tipo String armazena textos (O conteudo da variável sempre tem que estar entre "")

    val boolean: Boolean = true // O tipo Boolean armazena informação como verdadeiro (true) ou falso (false)

    val changingTypeP1 = 45
    println(changingTypeP1::class)

    val changingTypeP2 = changingTypeP1.toString()
    println(changingTypeP2::class)
}