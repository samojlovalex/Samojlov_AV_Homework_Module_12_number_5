class UfaStore(assortment: List<String>, prices: List<Double>) : PhoneStore(assortment, prices) {
    override val storeName = "Уфа Ой Сторэ"
    override var salesStatisticsStore = mutableMapOf<String, Int>()
    override var spendingStatisticsStore = mutableMapOf<String, Double>()
    override val currency= "₽"
    override val city = "Уфа"

    override fun getPrices(): MutableMap<String, Double> {
        return super.getPrices()
    }

    override fun pricePrint() {
        super.pricePrint()
    }

    override fun salesStatistics(numberInThePriceList: Int) {
        super.salesStatistics(numberInThePriceList)
    }

    override fun saleStatisticsPrint() {
        super.saleStatisticsPrint()
    }
}