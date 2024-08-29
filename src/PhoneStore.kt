@Suppress("UNUSED_CHANGED_VALUE")
abstract class PhoneStore(private val assortment: List<String>, private val prices: List<Double>) {

    abstract val storeName: String
    abstract var salesStatisticsStore: MutableMap<String, Int>
    abstract var spendingStatisticsStore: MutableMap<String, Double>
    abstract val currency: String
    abstract val city: String

    open fun getPrices(): MutableMap<String, Double> {
        //функция формирует прайс-лист из списка наименований телефонов и списка цен
        val mapOut = mutableMapOf<String, Double>()
        for (i in assortment.indices) {
            mapOut[assortment[i]] = prices[i]
        }
        return mapOut
    }
    open fun pricePrint() {
        //функция печатает прайс-лист
        var numberStroke = 1
        if (getPrices().isNotEmpty()) {
            println("Стоимость телефонов в магазине $storeName")
            for (i in getPrices()) {
                println("$numberStroke. ${i.key} - ${String.format("%.2f",i.value)} $currency")
                numberStroke++
            }
        }
    }

}