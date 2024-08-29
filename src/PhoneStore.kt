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
    open fun salesStatistics(numberInThePriceList: Int) {
        //функция учитывает статистику покупки телефонов конкретной марки и сумму покупок
        //этой марки телефона, печатает какой телефон куплен
        val lineInThePriceList = assortment[numberInThePriceList - 1]
        var oldValue = 0
        if (salesStatisticsStore[lineInThePriceList] != null) oldValue = salesStatisticsStore[lineInThePriceList] ?: 0
        salesStatisticsStore[lineInThePriceList] = ++oldValue
        var costOfThePosition = 0.0
        var salesStatistics = 0
        if (salesStatisticsStore[lineInThePriceList] != null) salesStatistics =
            salesStatisticsStore[lineInThePriceList] ?: 0
        if (getPrices()[lineInThePriceList] != null) costOfThePosition = getPrices()[lineInThePriceList] ?: 0.0
        spendingStatisticsStore[lineInThePriceList] = costOfThePosition * salesStatistics
        val salesStatisticsOutPosition = "Телефон $lineInThePriceList куплен в магазине $storeName\nСумма покупки: " +
                "${String.format("%.2f",getPrices()[lineInThePriceList])} $currency\nСпасибо за покупку!"
        println(salesStatisticsOutPosition)
        getLine("-")
    }

}