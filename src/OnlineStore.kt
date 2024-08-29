class OnlineStore (
    private val name: String,
    private val assortment: List<String>,
    private val ufaPrice: List<Double>,
    private val kazanPrice: List<Double>,
) {

    private val ufa = UfaStore(assortment, ufaPrice)
    private val kazan = KazanStore(assortment, kazanPrice)

    private val listStore = listOf(ufa, kazan)
}