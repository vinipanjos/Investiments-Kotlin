import java.text.SimpleDateFormat
import java.util.*

fun main() {

    val wallet = Wallet()
    var acaoValida:Boolean

    do {
        val random = Random()
        acaoValida = true
        println("Digite a ação e a quantidade que deseja comprar ou digite 0")
        val acaoNome = readLine()!!.toString()
        if (acaoNome == "0"){
            break
        }
        wallet.addAcao(Acao(acaoNome, random.nextDouble(), readLine()!!.toInt(), " "))

    }while (acaoValida)



    wallet.addAcao(Acao("Oi", 30.0, 20, " "))
    wallet.addAcao(Acao("Oi", 50.0, 20, " "))

    wallet.addAcao(Acao("Vivo", 30.0, 20, " "))

    wallet.relatorio()

}

data class Acao(
    val name: String,
    var price: Double,
    var amount: Int,
    var date: String
)

class Wallet {
    private val minhasAcoes = mutableMapOf<String, MutableList<Acao>>()

    /*
       Verifica se tem ação, se tem add na mesma gaveta
       senão não tem, cria uma uma gaveta, add a ação a gaveta,
       e add nova gaveta a carteira ou guarda roupa
        */
    fun addAcao(acao: Acao) {
        val date = Calendar.getInstance().time
        val dateTimeFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val dataCompra = dateTimeFormat.format(date)
        acao.date = dataCompra

        if (minhasAcoes.contains(acao.name)) {

            minhasAcoes[acao.name]?.add(acao)

        } else {
            val gaveta = mutableListOf<Acao>()
            gaveta.add(acao)
            minhasAcoes[acao.name] = gaveta
        }

    }

    fun relatorio() {


        println("Quantidade de ações adicionadas: ${minhasAcoes.size}")
        println("Minhas ações: ")
        println("--------------------------------------")

        minhasAcoes.forEach { gaveta ->
            println("Ação: ${gaveta.key}")
            var quant = 0
            var precoTotal = 0.0
            gaveta.value.forEach { item ->

//                println("$item")
                quant += item.amount
                precoTotal += (item.amount * item.price)
                println("Nome: ${item.name}, Quantidade: ${item.amount}, Preço:  ${item.price}, Data: ${item.date}")
            }

            println("Relatorio: \nPreco total: $precoTotal, Quantidade: $quant, Preço médio: ${precoTotal/quant}")
            println("--------------------------------------")

        }
    }
}