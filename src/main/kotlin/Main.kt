import java.util.*

fun main(args: Array<String>) {

    var validate = true
    do {
        println("Digite o nome, preço e quantidade da ação que deseja comprar, ou digite 0 para sair")
        val nome = readLine()
        val preco = readLine()
        val quant = readLine()
        if (nome.equals("0") && preco.equals("0") && quant.equals("0")) {
            !validate
            println("Aplicação sendo encerrada.")
        } else {
            val wallets = arrayListOf<String>()
            wallets.add(Wallet(nome, preco, quant).toString())
            }
    } while (!validate)

}

fun Wallet(name: String?, price: String?, amount: String?) {
    val priced: Double = price?.toDouble()!!
    val amounted: Double = amount?.toDouble()!!

    val totalInvest: Double = amounted * priced
    val toString = println(
        "Nome da ação: " + name + "\nPreço: " + price + "\nQuantidade: " + amount +
                "\nPreço médio:" + (totalInvest / amounted) + "\nValor total do investimento: " + totalInvest
    )
}


