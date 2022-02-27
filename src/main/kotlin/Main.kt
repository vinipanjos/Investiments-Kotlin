fun main() {

    val wallet = Wallet()


    wallet.addAcao(Acao("Tim", 30.0, 20, 1, 30.0, 600.0))

    wallet.addAcao(Acao("Oi", 30.0, 20, 1, 30.0, 600.0))
    wallet.addAcao(Acao("Oi", 30.0, 20, 1, 30.0, 600.0))

    wallet.addAcao(Acao("Vivo", 30.0, 20, 1, 30.0, 600.0))

    wallet.relatorio()

}

data class Acao(
    val name: String,
    var price: Double,
    var amount: Int,
    var count: Int,
    var averagePrice: Double,
    var totalPrice:Double
)

class Wallet {
    private val minhasAcoes = mutableMapOf<String, MutableList<Acao>>()
    var acoes = mutableListOf<Acao>()

    /*
       Verifica se tem ação, se tem add na mesma gaveta
       senão não tem, cria uma uma gaveta, add a ação a gaveta,
       e add nova gaveta a carteira ou guarda roupa
        */
    fun addAcao(acao: Acao) {
//        var  = mutableListOf<String>()
//        name.add(acao.name)
//        for (i in 0 until name.size){
//            if (!acoes[i].equals(acao.name)){
//                acoes.add(acao)
//            } else{
//                acoes[i].amount += acao.amount
//                acoes[i].averagePrice =  (acoes[i].price + acao.price)/2
//                acoes[i].totalPrice = acoes[i].averagePrice*acoes[i].amount
//            }
//        }
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
            gaveta.value.forEach { item ->
                println("$item")
            }
            println("--------------------------------------")
            acoes.forEach{dados ->
                println("Unificando dados das ações: ")
                println("$dados")
            }
        }
    }
}