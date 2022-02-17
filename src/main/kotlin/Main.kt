import java.awt.List
import java.util.*

fun main(args: Array<String>) {
    //val wallets = arrayListOf<String>()

    for (i in 0 until 3) {
        println("Digite o nome, preço e quantidade da ação que deseja comprar, ou digite 0 para sair")
        val nome = readLine()
        val preco = readLine()
        val quant = readLine()

        val wallet: Wallet = Wallet(nome, preco, quant)

        if (nome.equals("0") || preco.equals("0") || quant.equals("0")) {
            println("Aplicação sendo encerrada.")

        } else {
            Wallet(nome, preco, quant).addWallet(wallet) //= println(Wallet(nome, preco, quant).toString())
            Wallet(nome, preco, quant).toString()
        }
        println()
    }
}

class Wallet(var name: String?, var price: String?, var amount: String?) {
    private val allWallets = mutableListOf<Wallet>()

    val priced: Double = price?.toDouble()!!
    val amounted: Double = amount?.toDouble()!!

    val totalInvest: Double = amounted * priced

    fun addWallet(w: Wallet) {
        allWallets.add(w)
    }
    override fun toString(): String {
        return println("Nome da ação é " + name + ", avaliado em R$ " + price + ", comprou a quantidade de " + amount +
                " unidadess, com um preço médio de R$" + (totalInvest / amounted) + ". Valor total do investimento: R$" + totalInvest).toString()
    }
}


