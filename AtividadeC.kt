import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

fun getMenu(): menuDiscount { // Aqui é onde você informa qual que é o coportamento que sera utilizado no momento
    return BK()
}

fun main(args: Array<String>) {
    // Ctrl + / Coloca as linha em comentario
    //Criação de Array ou vetor como gosto de falar
    /*
    val items = intArrayOf(1, 2, 3, 4, 5) // A quantidade de espaço do array é pre limitado
    items.forEach { println(it) } // Imprime todos os Arrays informados. E it simboliza o array inteiro
    val users = arrayOf<AtividadeCUser?>(
        AtividadeCUser("Adriano", true),
        AtividadeCUser("Tiago")
    )
    val newList = users.plus(AtividadeCUser("Bruce")) // E para colocar um novo item tem que ser criado uma nova
    // váriavel
    //newList.forEach { println(it) }
    //println(users[0]) // Identificando entre [] você consegue escolher um Array específico, lembrando que começa a
    // númeração em 0 (ZERO)
    users[0] = null // Podemos mudar o valor das várivel de dentro do vetor com isso
    //println(users[0])
     */

    /*
    val users = listOf( // Isso cria uma lista sem limitações porem imutavel
        AtividadeCUser("Adriano", true),
        AtividadeCUser("Tiago"),
    )
     */

    /*
    val users = mutableListOf<AtividadeCUser?>( // Isso cria uma lista sem limitações e mutavel
        AtividadeCUser("Adriano", true),
        AtividadeCUser("Tiago"),
        AtividadeCUser("Lucas", true),
        AtividadeCUser("Bruce")
    )
    users[0] = AtividadeCUser("Erivan", true) // Modificar itens a lista
    users.add(AtividadeCUser("Adriano", true)) // Adicionar itens a lista
    users.removeAt(1) // Remover um item da lista
    users.forEach { println(it) }
     */

    /*
    val a = mutableListOf("Tiago", "Lucas")
    val b = listOf("João", "Peter", "Adriano")
    b.filterTo(a, { it.contains("a")}) // Com isso ele vai juntar as duas listas em uma pegando somente os nomes
    // com a letra a
    //println(a) // Perceba que o nome João não foi considerado como nome com a letra a pois o a está com ã
    val c = listOf("A","B")
    val d = listOf("E", "F")
    val all = listOf(c, d)
    println(all) // Aqui você consegue ver que as listas apesar de juntas em uma váriavel eslas ainda estão separadas
    println(all.flatten()) // Com isso você funde as duas listas
     */

    /*
    calc(5, 5, ::sum)
    calc(5, 5, ::minus)
    calc(5, 5, ::divide)
     */

    /*
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val numbers2 = listOf(1, 2, 5, 10, 12, 16)
    val result = numbers.union(numbers2) // Aqui vai fazer a mesclagem das lista e vai tirar os valores repitidos
    result.forEachIndexed { index, el -> // Isso vai fazer ele mostrar o indice e que esta armazenado
        println("index: $index, elemento id: $el")
    }
    for (numbers in numbers) { // Assim como o for em outras liguagens o for cria areas delimitadas de funcionamento de
        // condições
        println(numbers)
    }
    for(index in 0 until 3) { // Aqui nos definimos que a contagem vai ser basiada no index e que ela vai ir
        // de 0 a 3 sem contar o 3, e para isso utilizamos a codificação until
        println("index: $index, elemento ID: ${numbers[index]}")
    }
    // Tem outro jeito de fazer isso mais injuto que é
    for(index in 0 .. 3) {
        println("index: $index, elemento ID: ${numbers[index]}")
    }
    for (i in 0 until 20 step 2) { // Isso ira fazer a contagem do i pulando a númeração impar
        println("N#$i")
    }
    // Pode ser feito em formado de decrecente
    for (i in 20 downTo  0 step 2) { // Isso ira fazer a contagem decresente do i pulando a númeração impar
        println("N#$i") // Observe que aqui ele acrecentou o 0 (Zero) porem o until não acresenta o 20 (Vinte)
    }
    var i = 0
    while(i < 10) { // Aqui o bom e velho while que nos conhecemos
        println(i)
        i++
    }
     */

    /*
//    val product = mapOf( // Ele faz uma lista com dois parametro. OBS: o parametro pode ser variado
//        "Android" to "Google",
//        "iOS" to "Apple",
//        "Windows" to "Microsoft",
//        "Linux" to "Linux Mint"
//    )
    val product = mutableMapOf( // Assim como a array, list, set o map para ser mutavel tem que colocar a configuração
    // mutable
        "Android" to "Google",
        "iOS" to "Apple",
        "Windows" to "Microsoft",
        "Linux" to "Linux Mint"
    )
    val res = product ["Android"] // Acha o seu complemento de comparação
    val res = product.getOrDefault("Android 2", "Não existe empresa para esse sitema opreacional") // tenta achar
    // o seu coplemento de comparação, porem caso não ache não ira retornar como nulo mas sim com uma mendagem ou resltado
    // pré programado
    // Tem outro jeito de se fazer o .getOrDefault, e esse metodo te da mais opções de respostas
    val res = product.getOrElse("Android 2") {
        println("EXP: Você ENVIA para o servidor")
        "Não existe empresa para esse sitema opreacional"
    }
    println(res)
    val hasWindows = product.containsKey("Windows") // Isso ve se o valor procurado existe na lista
    if (hasWindows) { // Com isso é possivel fazer uma lógica com essa informação
        println("Abrir o app")
    } else {
        println("Abra a loja de vendas do Windows")
    }
    product["Android"] = "Empresa XYZ" // Aqui muda as informações de dentro do map
    //product.remove("Android") // Aqui nos vamos remover um dos itens do map
    //product.clear() // Vai limpar toda o map
    product.remove("Android", "Google") // Podemos colocar ois criterios para exclução, porem se não for atendido essa
    // condição não sera deletado nenhuma informação
    println(product.keys) // Olha pra as 1 codição do map
    println(product.values) // Olha para 2 condição do map
     */

    /*
    val contacts = mapOf(
        1 to "Tiago",
        2 to "Gabriel",
        3 to "Adenilda",
        4 to "Roberto",
        5 to ""
    )
    val r = contacts.filter { it.value.isNotEmpty() }
        .map{ it.value.substring(0, 1)}
    println(r)
     */

    /*
    val obj:Any = getObject(2)
    if (obj is Int) println(obj) // Com o is checamos se a condição é verdade
    else println(obj::class) // Com isso nos conseguimos ver o tipo da váriavel
    val obj2:Any = getObject(2)
     */

    divide2(10, 0)
    showView()
    val Usuario = customer("Adriano")
    Usuario.MenuDiscount = getMenu()
    Usuario.appScreen()
}

fun sum(x:Int, y: Int): Int {
    return x + y
}
fun minus(x:Int, y: Int): Int {
    return x - y
}
fun divide(x:Int, y: Int): Int {
    return x / y
}
fun calc(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println("O resultado da operação $a com $b é igual a $result")
}

fun getObject(value: Int): Any { // Todo tipo de váriavel é do tipo Any, com isso  nos conseguimos ter retorno
    // Todo * diferentes dependendo do resultado
    return when(value) {
        1 -> 1
        2 -> "Aula"
        3 -> true
        else -> 1.0
    }
}

fun divide2(x:Int, y: Int) { // Podemos tentar fazer o controle de erros
    try { // O ploco try faz com que o função tente fazer a operação
        println(x / y)
    }
    catch (e: ArithmeticException) { // Com o catch podemos colocar o erro que é possivel calsar e dar uma solução a ele
        println("Não é possivel fazer uma divisão por ZERO") // Como por exemplo o erro de fazer uma divisão por zero
    // que gera um erro ArithmeticException. Esse metodo só consegue resolver os erros que são TimeError, que são tipos
    // de erro que so dão errado quando os programa esta em execução
    } catch (e: Exception) { // Podemos ser genericos e colocar o erro como Exception assim ele vai englobar 90% dos
        // erro de tipo TimeError, mas claramente sendo genericos nos não estamos resolvendo o problema só o cotornando
        println("Erro não esperado")
    }
}
fun showView() { // Nos podemos criar nossos propios erros na código para fazer mensagens de informação para caso o
    // usuário tente colocar a informação errada
    try {
        val prod = applyDiscount(100.0, 51)
        println(prod)
    } catch (e:IllegalArgumentException) {
        println(e.message) // Isso ira passar a mensagem de erro para o usuário
    }
}
fun applyDiscount(price: Double, value:Int): Double {
    if (value > 50) {
        throw IllegalArgumentException("Desconto muito alto!") // Fazendo isso nos idincamos o tipo de erro e indicamos
    // o motivo de o ter causado
    }
    val discount = value * price / 100
    return price - discount
}
class customer(val name:String) {
    lateinit var MenuDiscount: menuDiscount // Aqui eu estou conectando o usuario a interface, para passar a informação

    fun appScreen() { // Aqui essa funão iria de fato mostrar para o usuario a informação recebida da interface, então
        // como nesse exemplo mostraria para meu usuário quem é o restaurante que está com o desconto do dia e o seu
        // cardápio
        val dayCombo = MenuDiscount.ComboOfTheDay()
        println(dayCombo)
    }
}
interface menuDiscount { // Vamos criar uma interfaze que ira consersar com as funções internas permitindo que alterações de
    // variáveis seja mais faceis de ser feitas
    fun ComboOfTheDay(): String // Vai mostrar os menus com o disconto do dia
}
class McDonald : menuDiscount  {
    override fun ComboOfTheDay(): String{ // Isso vai fazer a class se comunicar com a interface
        return "Cardápio do McDonald's com desconto do dia"
    }
}
class BK : menuDiscount {
    override fun ComboOfTheDay(): String{ // Isso vai fazer a class se comunicar com a interface
        return "Cardápio do Burger King com desconto do dia"
    }
}
class KFC : menuDiscount  {
    override fun ComboOfTheDay(): String{ // Isso vai fazer a class se comunicar com a interface
        return "Cardápio do Kentucky Fried Ckicken (KFC) com desconto do dia"
    }
}
class Girafas : menuDiscount  {
    override fun ComboOfTheDay(): String{ // Isso vai fazer a class se comunicar com a interface
        return "Cardápio do Girafas com desconto do dia"
    }
}