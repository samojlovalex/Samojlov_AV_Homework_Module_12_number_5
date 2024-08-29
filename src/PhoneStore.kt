@Suppress("UNUSED_CHANGED_VALUE")
abstract class PhoneStore(private val assortment: List<String>, private val prices: List<Double>) {

    abstract val storeName: String
    abstract var salesStatisticsStore: MutableMap<String, Int>
    abstract var spendingStatisticsStore: MutableMap<String, Double>
    abstract val currency: String
    abstract val city: String}