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

    val long3: Long = 1_200 // Para ficar mais fácil de se ser o número que esta no long você pode colocar um underline para separar a casa do milhar da demais

    // Operações matemáticas (+ - / * !)

    val conta1 = 23 // Não da para deixar uma variável sem o seu valor inicial
    val conta2 = 64
    val conta3 = "OK"
    val conta4 = "123"
    var soma = 0
    var subtracao = 0
    var divisao = 0
    var mutiplicacao = 0
    var soma2 = ""
    soma = conta1 + conta2 // Aqui podermos fazer contas como soma
    println(soma)
    subtracao = conta1 - conta2 // Subtração
    println(subtracao)
    divisao = conta1 / conta2 // Divisão
    println(divisao)
    mutiplicacao = conta1 * conta2 // Mutiplicação
    println(mutiplicacao)
    soma2 = conta3 + conta4 // Tambem podemos somar textos
    println(soma2)
    val booleana = false // A outra operação que temos é a booleana
    println(boolean)

    // Codificações de texto

    val nome : String = "Adriano" // String é uma sequência de chars
    val nomedomeio : Char = 'S' // Para utilizar o char você tem que utilizar '' em ves de "" ele ocupa menos espaço do que a string, ocupando somente 16 bits
    val nomeespaco = '\t' // Utilizando o chars podemos fazer cofigurações especificas como utilizar o espaço do TAB
    val mudadelinha = '\n' // Ou bular a linha
    val nome2 = "Erivan"
    println(nome+nomeespaco+nomedomeio+mudadelinha+nome2+nomeespaco+nomedomeio)

    // Operando objetos

    val Nnome = nome.length  // Isso faz com que retorne a quantidade de caracteres tem a variável
    println(Nnome) // Quando colocamos .funsão em um objeto como uma String nos estamos fazerndo uma funsão com ela
    val Minnome = nome.lowercase() // Isso faz com que retorne a variável com todas as letras minúsculas
    val Maxnome = nome.uppercase() // Isso faz com que retorne a variável com todas as letras maiúsculas
    println(Minnome) // Apesar disso também ser uma funsão ela e uma funsão que alterar propriedade
    println(Maxnome) // Diferente da funsão comum que não altera uma variável so utiliza a variálvel para algo
}