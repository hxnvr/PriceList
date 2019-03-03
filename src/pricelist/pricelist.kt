@file:Suppress("UNUSED_PARAMETER", "unused")
package pricelist
data class Product(var name: String, var price: Double, var code: Int)

class PriceList {
    var list = mutableListOf<Product>()
    fun add(newProductName: String, newProductCode: Int, newProductPrice: Double) {
        if (list.none { it.code == newProductCode })
            list.add(Product(newProductName, newProductPrice, newProductCode))
        else println("Такой продукт уже имеется")
    }
    fun clearByCode(unCode: Int): MutableList<Product> {
        list = list.filter{it.code != unCode}.toMutableList()
        return list
    }
    fun priceChangeByCode(code: Int, newPrice: Double): MutableList<Product> {
        list.map{if (it.code == code) it.price = newPrice}
        return list
    }
    fun nameChange(code: Int, newName: String): MutableList<Product> {
        list.map{if (it.code == code) it.name = newName}
        return list
    }
    fun purchasePrice(num: Int, code: Int): Double {
        val prod = list.filter { it.code == code }
        return prod[0].price * num.toDouble()
    }
}

