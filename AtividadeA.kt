// OBS: O kotem possue margem para você organizar melhor seu códico
fun main() {
    println("Hello Word") // Como padrão println server para mostrar na tela de execução alguma informação "output"

    var product = "iMac" // var é o comando para criar uma variável
    println(product) // Como pode ser visto aqui a infomação contida na variável

    product = "iPhone" // Aqui eu estou subescrevendo a informação da variável
    println(product) // Como pode ser visto aqui a variável mudou de infomação

    //var product = "Android" // NÃO pode ser feito isso, isso irá dar uma erro de compilação, pois a variável product
    // já foi criada

    val PI = 3.14 // val é o comando para criar uma variável imutável
    //PI = 2.35 // Sendo aasim caso você faça uma ação para tentar muda-lá o seu programa irá dar um erro de compilação

    var price = 31 // Para colocar valores númerico não precisa colocar o valor entre "", somente variaveis de texto
    // precisão estar entre ""
    println(price)

    // Quando você colocar // na linha de código tudo que você escreve depois dessas barra não são intepretadas
    // pelo código e elas
    // servem para você DOCUMENTAR, REFERENCIAR, FAZER NOTAS sobre o código que você quer referir. Isso é muito
    // importante para organização do seu arquivo

    // TODO: Terminar os códigos para zxy // Detendendo do que você escreve a informação pode mudar de cor

    println(product::class) // Quando nos colocamos os ::class na função print você vai ter um output de informação
    println(PI::class) // A infomação que o programa ira te dar nesse caso é que é o tido de variável que
    // é essa que você informou
    println(price::class) // Existe varios tipos de variável as mais comuns são double, String, int

    var reminder = "F23" // Quando você utiliza a função var você está deixando o computador escolher automaticamente
    // que tipo de variável ele irá utilizar
    // Com isso nem sempre o comutador irá fazer a melhor escolha ou a ecolha que você deseja.

    val number1: Int = 23 // Sé nos quisermos podemos definir na programação qual é o tipo de variável que nos queremos
    val text: String = "teste 1" // que a variável fique.
    val number2: Double = 23.5 // Existem varios tipos de tipos de variável.

    // Quando você não define o tipo da variável ela é do TIPOS INFERIDO
    // Esses tipos como double, String e int são chamados de TIPOS PRIMITIVOS
    // Abaixo veja algumas outras tipos de tipos primitivos e suas limitasoes

    val byte: Byte = 8 // Ele consegue armazenar até 8-bit de espaço númerico
    val shout: Short = 16 // Ele conseque armazenar até 16-bit de espaço númerico
    val number3: Int = 31 // Ele consegue armazenar até 32-bit de espaço númerico (Usaremos ele 99% do tempo)
    val long1: Long = 192 // Ele consegue armazenar até 64-bit de espaço númerico

    val float1: Float = 31.99f // Ele consegue armazenar até 32-bit de espaço númerico com ponto flutuante "Número
    // quebrado" (É obrigatorio utilizar o f no final)
    val double: Double = 31.99 // Ele consegue armazenar até 64-bit de espaço númerico com ponto flutuante

    val long2= 192L // Para facilitar nos podemos simplificar e não ter que escrever o tipo na frente você tambem pode
    // usar essa forma para definir o tipo
    val float2= 31.99f // Long e Float utilizando um L ou um f na frente de uma definição de variável
    println(long2::class)
    println(float2::class)

    val string: String = "Text" // O tipo String armazena textos (O conteudo da variável sempre tem que estar entre "")

    val boolean: Boolean = true // O tipo Boolean armazena informação como verdadeiro (true) ou falso (false)

    var variavelnula : String? = null // Para criar variáveis nulas no Kotlin você tem que indentificar que essa
    // variável pode amarzenar o valor null que é nulo

    val changingTypeP1 = 45
    println(changingTypeP1::class)

    val changingTypeP2 = changingTypeP1.toString()
    println(changingTypeP2::class)

    val long3: Long = 1_200 // Para ficar mais fácil de se ser o número que esta no long você pode colocar um underline
    // para separar a casa do milhar da demais

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
    val nomedomeio : Char = 'S' // Para utilizar o char você tem que utilizar '' em ves de "" ele ocupa menos espaço do
    // que a string, ocupando somente 16 bits
    val nomeespaco = '\t' // Utilizando o chars podemos fazer cofigurações especificas como utilizar o espaço do TAB
    val mudadelinha = '\n' // Ou bular a linha
    val nome2 = "Erivan"
    println("Eu sou "+nome+nomeespaco+nomedomeio+mudadelinha+"Já o meu irmão é "+nome2+nomeespaco+nomedomeio) // Pode
    // ver com isso que fica muito dificil fazer a codificação então temos outro jeito de fazer isso

    println("Eu sou $nome $nomedomeio \n Já o meu irmão é $nome2 $nomedomeio") // Assim o seu codigo fica mais limpo
    val welcome = """
        Seja bem vindo ao nosso site!
        Você é um cliente muito especial para nos! ^^
    """ // Você támbem pode colocar """ """ o programa imprimir exatamente a formatação que você indicou
    // Porem perceba que os espaços da formatação de codigo estão ali e vão ser imprimidos juntos com o que você
    // escreveu. E se você tirar aquela formatação de codigo o seu código vai ficar desorganizado.
    println(welcome)

    // Operando objetos

    val Nnome = nome.length  // Isso faz com que retorne a quantidade de caracteres tem a variável
    println(Nnome) // Quando colocamos .funsão em um objeto como uma String nos estamos fazerndo uma funsão com ela
    val Minnome = nome.lowercase() // Isso faz com que retorne a variável com todas as letras minúsculas
    val Maxnome = nome.uppercase() // Isso faz com que retorne a variável com todas as letras maiúsculas
    println(Minnome) // Apesar disso também ser uma funsão ela e uma funsão que alterar propriedade
    println(Maxnome) // Diferente da funsão comum que não altera uma variável so utiliza a variálvel para algo

    val welcome2 = """
        Seja bem vindo ao nosso site!
        Você é um cliente muito especial para nos! ^^
    """.trimIndent() // O jeito para resolver o problema do testo relatado anteriormente é utilizando a função
    // .trimIndent() que vai remover a configuração lateral
    println(welcome2)
    val itens = """
        Item 1;
        Item 2
    """.replaceIndent(" - ") // Podemos utilizar outros funções para fazer resultados parecidos, como
    // a .replaceIndent que vai trocar esse espaço vazio por o caracter que eu escolher
    println(itens)

    var contagemnulo = variavelnula?.length // As variáveis com o valor nulo tem problemas em fazer operações
    println(contagemnulo) // Outro jeito de fazer uma operação com uma variavel nula é utilizando uma função

    // Funsão lógica

    if (product.length > 5){ // if é a funsão lógica mais básica ele apesar faz uma operação se o resultado for True
        println("Produto cadastrado")
    }
    else{ // Caso o resultado de False ele vai fazer o resurso que estiver no else
        println("Produto não cadastrado")
    }

    // As funções tem as esprecões de:
    //  + soma; - subtração; * mutiplicação; / divisão; = igual em espaço armazenado ; == igualdade valor armazenado;
    //  != diferente,

    if (product == "iPhone" && conta1 == 31 ){ // Nas funções nos temos as mutcondições feitas pelo && E ou || OU
        println("sucesso")
    }
    else{
        println("falha")
    }
    // E
    // True | True    = True
    // True | False   = False
    // False | True   = False
    // False | False  = False

    if (product == "iPhone" || conta1 == 31 ){
        println("sucesso")
    }
    else{
        println("falha")
    }
    // OU
    // True | True    = True
    // True | False   = True
    // False | True   = True
    // False | False  = False

    var product2 = "iPhone"
    println(product == product2) // Codemos fazer comparações de strings
    println(product.equals(product2)) // Fazendo assim temos o mesmo resutado porem codificamente deixa mais díficil de
    // se ver

    if (variavelnula != null){ // Assim que se posibilita fazer uma operação com variáveis nulas
        val contagemnulo2 = variavelnula.length
        println(contagemnulo2)
    }
    val contagemnulo3 = if (variavelnula != null) variavelnula.length else 0 // Esse é o outro jeito de fazer um if de
    println(contagemnulo3) // forma mais inxota codificamente falando, porem na minha opnião fica horrivel e dificil de
    // se ler
    val contagemnulo4 = variavelnula?.length ?: 0 // Esse é um outro jeito de se fazer uma funão if, fazendo com que
    println(contagemnulo4) //  o else seja ?: e nessa forma ele é chamado de operação Elvis ...
    // Sim é baseado no Elvis Presley é para ? ser o topete e os : ser os olhos ... ?:
}