@file:Suppress("UNUSED_PARAMETER", "unused")
package pricelist

 class Product(private var name: String, private var price: Double ) {
     fun getPrice(): Double {
         return price
     }

     fun getName(): String {
         return name
     }

     fun newPrice(newPrice: Double) {
        if (newPrice > 0) {
            this.price = newPrice
        } else throw IllegalArgumentException("Неверно указана цена")
    }

     fun newName(newName: String){
         if (!newName.isBlank()) {
             this.name = newName
         } else throw IllegalArgumentException("Неверно указано название товара")
     }
}


class PriceMap(private var map: MutableMap<Int,Product>) {

    fun add( newProductCode: Int, newProduct: Product): Boolean {
        if (map.containsKey(newProductCode)) return false
        if (newProduct.getPrice() <= 0 || newProduct.getName().isBlank()) throw IllegalArgumentException()
        else map[newProductCode] = newProduct
        return true
    }

    fun clear(unCode: Int): Boolean =
        if (map.containsKey(unCode)) {map.remove(unCode)
            true
        } else false


    private fun find(code: Int): Product {
       if (map[code] != null) return map[code]!!
        throw IllegalArgumentException()
    }

    fun priceChange(code: Int, newPrice: Double): Boolean =
         if (map.containsKey(code)) {
            find(code).newPrice(newPrice)
            true
        } else false


    fun nameChange(code: Int, newName: String): Boolean =
         if (map.containsKey(code)) {
            find(code).newName(newName)
            true
        } else false


    fun purchasePrice(goods: List<Pair<Int, Int>>): Double {
        var sum = 0.0
        for (i in 0 until goods.size){
            sum += find(goods[i].first).getPrice() * goods[i].second
        }
        return sum
    }
}

