@file:Suppress("UNUSED_PARAMETER", "unused")
class Product(var name: String, var price: Double, var code: Int)

class Pricelist {
    var list = mutableListOf<Product>()
    fun add(newProductName: String, newProductCode: Int, newProductPrice: Double) {
        list.add(Product(newProductName, newProductPrice, newProductCode))
    }
    fun clearByName(unName: String){
         list = list.filter{it.name != unName}.toMutableList()
    }
    fun clearByCode(unCode: Int){
        list = list.filter{it.code != unCode}.toMutableList()
    }
    fun priceChangeByName(name: String, newPrice: Double) {
        list.map{if (it.name == name) it.price = newPrice}
    }
    fun priceChangeByCode(code: Int, newPrice: Double){
        list.map{if (it.code == code) it.price = newPrice}
    }
    fun nameChange(code: Int, newName: String){
        list.map{if (it.code == code) it.name = newName}
    }
}

