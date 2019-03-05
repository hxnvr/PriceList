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
}

class PriceList {
    private var map = mutableMapOf<Int,Product>()
    fun add(newProductName: String, newProductCode: Int, newProductPrice: Double): MutableMap<Int,Product> {
        if (map.containsKey(newProductCode)) throw IllegalArgumentException("Продукт с таким кодом уже существует")
        else map[newProductCode] = Product(newProductName, newProductPrice)
        return map
    }
    fun clear(unCode: Int): MutableMap<Int,Product> {
       if (map.containsKey(unCode)){
           map.remove(unCode)
           return map
       } else throw IllegalArgumentException("В списке нет продукта с таким кодом")
    }
    private fun find(code: Int): Product{
        return map[code]!!
    }
    fun priceChange(code: Int, newPrice: Double):  MutableMap<Int,Product> {
        if (map.containsKey(code)) {
            find(code).setprice(newPrice)
            return map
        }
        else throw IllegalArgumentException("В списке нет продукта с таким кодом")
    }
    fun nameChange(code: Int, newName: String): MutableMap<Int,Product> {
        if (map.containsKey(code)) {
            find(code).setname(newName)
            return map
        }
        else throw IllegalArgumentException("В списке нет продукта с таким кодом")
    }
    fun purchasePrice(num: Int, code: Int): Double {
        return find(code).price * num
    }
}

