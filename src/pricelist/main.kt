package pricelist
import pricelist.PriceList
fun main() {
    val test = PriceList()
    test.add("Молоко", 384,5.33)
    test.add("Хлеб", 3846,16.45)
    println(test)
    println(test.purchasePrice(3,384))
}

