import kotlin.io.println as println

fun main(args: Array<String>) {

    val wallet = mutableListOf<Wallet>()
    val name = mutableListOf<String>()
    val price = mutableListOf<Double>()
    val amount = mutableListOf<Double>()

    name.add("Oi")
    price.add(25.0)
    amount.add(20.0)

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
        wallet.add(Wallet(nome, preco, quant))
        for (j in 0 until i) {
            if (nome == name[j]) {
                wallet[j].amount += quant
                wallet[j].price = (preco + wallet[j].price) / 2
                wallet[i] = Wallet("", 0.0, 0.0)
            }
        }
    }
    for (i in 0 until name.size) {
        if (wallet[i].name != "")
            wallet[i].toString()
    }
}

class Wallet(val name: String, var price: Double, var amount: Double) {

    override fun toString(): String = println(
        "Nome da ação é " + name + ", comprou " + amount +
                " unidadess, com um preço médio de R$" + ((amount * price) / amount) + ". Valor total do investimento: R$" + (amount * price)
    ).toString()
}




