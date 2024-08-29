class OnlineStore (
    private val name: String,
    private val assortment: List<String>,
    private val ufaPrice: List<Double>,
    private val kazanPrice: List<Double>,
) {

    private val ufa = UfaStore(assortment, ufaPrice)
    private val kazan = KazanStore(assortment, kazanPrice)

    private val listStore = listOf(ufa, kazan)

    private fun listStorePrint() {
        //функция выбора города из списка имеющихся магазинов
        for (i in listStore.indices) {
            println("${i + 1} - ${listStore[i].city}")
        }
    }
}