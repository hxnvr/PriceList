@file:Suppress("UNUSED_PARAMETER", "unused")
package pricelist
 class Product(var name: String, var price: Double) {
    fun setprice(newPrice: Double) {
        if (newPrice > 0) {
            this.price = newPrice
        } else throw IllegalArgumentException("Неверно указана цена")
    }

     fun setname(newName: String){
         if (newName != "") {
             this.name = newName
         } else throw IllegalArgumentException("Неверно указано название товара")
     }
     override fun toString():String{
         return " Название: $name; Цена: $price"
     }
}

class PriceList {
    private var map = mutableMapOf<Int,Product>()
    fun add(newProductName: String, newProductCode: Int, newProductPrice: Double): Boolean {
        if (map.containsKey(newProductCode)) return false
        else map[newProductCode] = Product(newProductName, newProductPrice)
        return true
    }

    fun clear(unCode: Int): Boolean {
        return if (map.containsKey(unCode)){
            map.remove(unCode)
            true
        } else false
    }

    private fun find(code: Int): Product{
        return map[code]!!
    }

    fun priceChange(code: Int, newPrice: Double): Boolean {
        return if (map.containsKey(code)) {
            find(code).setprice(newPrice)
            true
        } else false
    }

    fun nameChange(code: Int, newName: String): Boolean {
        return if (map.containsKey(code)) {
            find(code).setname(newName)
            true
        } else false
    }

    fun purchasePrice(num: Int, code: Int): Double {
        return find(code).price * num
    }
    override fun toString(): String {
        return map.toString()
    }
}

