import kotlin.io.println as println

fun main(args: Array<String>) {

    val wallet = mutableListOf<Wallet>()
    val name = mutableListOf<String>()
    val price = mutableListOf<Double>()
    val amount = mutableListOf<Double>()

//    wallet.add(Wallet("Tim", 30.0, 20.0, 1, 30.0))
//
//    wallet.add(Wallet("Tim", 30.0, 20.0, 1, 30.0))
//
//    wallet.add(Wallet("Tim", 30.0, 20.0, 1, 30.0))

    name.add("Tim")
    price.add(30.0)
    amount.add(20.0)

    name.add("Vivo")
    price.add(25.0)
    amount.add(20.0)

    name.add("Claro")
    price.add(100.0)
    amount.add(20.0)

    name.add("Oi")
    price.add(20.0)
    amount.add(20.0)

    name.add("Claro")
    price.add(45.0)
    amount.add(20.0)

    name.add("Vivo")
    price.add(30.0)
    amount.add(20.0)

    name.add("Tim")
    price.add(10.0)
    amount.add(20.0)

    name.add("Tim")
    price.add(10.0)
    amount.add(20.0)

    name.add("Tim")
    price.add(10.0)
    amount.add(20.0)

    name.add("Tim")
    price.add(10.0)
    amount.add(20.0)

    for (i in 0 until price.size) {
        val nome = name[i]
        val preco = price[i]
        val quant = amount[i]

        wallet.add(Wallet(nome, preco, quant, 1, preco))
        for (j in 0 until i) {
            if (nome == name[j]) {
                wallet[j].count++
                wallet[j].amount += quant
                wallet[j].price += preco
                wallet[j].averagePrice = wallet[j].price / wallet[j].count
                wallet[i] = Wallet("", 0.0, 0.0, 0, 0.0)
            }
        }
    }
    for (i in 0 until wallet.size) {
        if (wallet[i].name != "")
        wallet[i].toString()
    }
}

class Wallet(val name: String, var price: Double, var amount: Double, var count: Int, var averagePrice: Double) {

    override fun toString(): String = println(
        "Nome da ação: " + name + "\nComprou " + amount +
                " unidadess, com um preço médio de R$" + averagePrice + "\nValor total do investimento: R$" + averagePrice * amount + "\n"
    ).toString()
}





