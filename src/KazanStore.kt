class KazanStore(assortment: List<String>, prices: List<Double>) : PhoneStore(assortment, prices), RepairShop {
    override val storeName = "Казань Ой Сторэ"
    override var salesStatisticsStore = mutableMapOf<String, Int>()
    override var spendingStatisticsStore = mutableMapOf<String, Double>()
    override val currency = "₽"
    override val city = "Казань"
    var phoneWasBeingRepaired = false

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

    override fun repairShop(phoneWasBeingRepaired: Boolean): Boolean {
        return super.repairShop(phoneWasBeingRepaired)
    }
}