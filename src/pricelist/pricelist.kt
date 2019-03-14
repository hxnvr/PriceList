@file:Suppress("UNUSED_PARAMETER", "unused")
package pricelist

 // field
 class Product(private var name: String, var price: Double) {
    fun newPrice(newPrice: Double) {
        if (newPrice > 0) {
            this.price = newPrice
        } else throw IllegalArgumentException("Неверно указана цена")
    }

     fun newName(newName: String){
         if (newName != "") {
             this.name = newName
         } else throw IllegalArgumentException("Неверно указано название товара")
     }
}

class PriceList (var map: MutableMap<Int,Product>) {
    fun add( newProductCode: Int, newProduct: Product): Boolean {
        if (map.containsKey(newProductCode)) return false
        else map[newProductCode] = newProduct
        return true
    }

    fun clear(unCode: Int): Boolean {
        return if (map.containsKey(unCode)){
            map.remove(unCode)
            true
        } else false
    }

    // !!
    private fun find(code: Int): Product{
        return map[code]!!
    }

    fun priceChange(code: Int, newPrice: Double): Boolean {
        return if (map.containsKey(code)) {
            find(code).newPrice(newPrice)
            true
        } else false
    }

    fun nameChange(code: Int, newName: String): Boolean {
        return if (map.containsKey(code)) {
            find(code).newName(newName)
            true
        } else false
    }

    fun purchasePrice(goods: List<Pair<Int, Int>>): Double {
        var sum = 0.0
        for (i in 0 until goods.size){
            sum += find(goods[i].first).price * goods[i].second
        }
        return sum
    }
}

