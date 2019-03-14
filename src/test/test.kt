package test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pricelist.PriceList
import pricelist.Product



class Tests {
    private val testMap = PriceList(
        mutableMapOf(
            45 to Product("Молоко", 53.3),
            67 to Product("Печенье", 60.4), 2 to Product("Банан", 33.0)
        )
    )

    @Test
    fun add() {
        assertFalse(testMap.add(45, Product("Колбаса", 343.2)))
        assertFalse(testMap.add(67, Product("Хлеб", 33.0)))
        assertFalse(testMap.add(2, Product("Виноград", 343.2)))
        assertTrue(testMap.add(445, Product("Вода", 34.25)))
        assertTrue(testMap.add(8945, Product("Картошка", 14.5)))
    }

    @Test
    fun clear(){
        assertTrue(testMap.clear(67))
        assertTrue(testMap.clear(45))
        assertTrue(testMap.clear(2))
        assertFalse(testMap.clear(355))
        assertFalse(testMap.clear(475))
    }

    @Test
    fun priceChange() {
        assertFalse(testMap.priceChange(415, 323.22))
        assertFalse(testMap.priceChange(15, 3.2))
        assertTrue(testMap.priceChange(45,222.11))
        assertTrue(testMap.priceChange(2,12.4))
    }

    @Test
    fun nameChange() {
        assertTrue(testMap.nameChange(45, "Кефир"))
        assertTrue(testMap.nameChange(67, "Пряники"))
        assertFalse(testMap.nameChange(345,"Пиво"))
    }

    @Test
    fun purchasePrice() {
        assertEquals(167.0, testMap.purchasePrice(listOf(45 to 2, 67 to 1)))
        assertEquals(489.9, testMap.purchasePrice(listOf(2 to 10, 45 to 3)))
    }
}