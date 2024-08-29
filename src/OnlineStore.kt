const val NAME_ONLINE_STORE = "ОЙ СТОРЭ"

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

    private fun statisticsStore() {
    //функция печатающая статистику покупок в конкретном магазине
        for (i in listStore.indices) {
            if (listStore[i].salesStatisticsStore.isNotEmpty()) {
                listStore[i].saleStatisticsPrint()
            }
        }
    }

    fun openOnlineStore() {
        println(
            "$name!\nДобро пожаловать в наш онлайн магазин продажи сотовых телефонов: $NAME_ONLINE_STORE" +
                    "\nЖелаете посмотреть ассортимент наших магазинов?" +
                    "\n1 - Да\n2 - Нет"
        )

        var choice = readln()

        val correctChoice = (choice == "1") || (choice == "2")

        choice = inCorrectChoice(correctChoice, choice)

        if (choice == "1") {
            while (true) {

                statisticsStore()

                println(
                    "\n$name!\nВыберете город из которого хотите заказать себе телефон"
                )
                listStorePrint()
                println("\n0 - Закончить покупки")
                var choiceCity = readln()
                val correctChoiceCity = choiceCity in "0"..listStore.size.toString()

                choiceCity = incorrectChoiceCity(correctChoiceCity, choiceCity)

                if (choiceCity in "1"..listStore.size.toString()) {

                    enterInStore(choiceCity)

                    choiceRepairStore(choiceCity)

                    println("\nВыберете телефон из ассортимента\n")
                    listStore[choiceCity.toInt() - 1].pricePrint()
                    println("\n0. Вернуться к выбору магазина")

                    var choicePhone = readln()
                    val correctChoicePhone = choicePhone in "0"..assortment.size.toString()

                    choicePhone = inCorrectChoicePhone(correctChoicePhone, choiceCity, choicePhone)

                    if (choicePhone in "1"..assortment.size.toString()) {
                        listStore[choiceCity.toInt() - 1].salesStatistics(choicePhone.toInt())
                        choice = "1"
                    } else choice = "1"

                } else {
                    println("До свидания ${name}, всегда рады увидеть Вас в нашем магазине $NAME_ONLINE_STORE")
                    break
                }

            }
        }

        if (choice == "2") println("До свидания ${name}, всегда рады увидеть Вас в нашем магазине $NAME_ONLINE_STORE")
    }

    private fun inCorrectChoicePhone(correctChoicePhone: Boolean, choiceCity: String, choicePhone: String): String {
        var correctChoicePhone1 = correctChoicePhone
        var choicePhone1 = choicePhone
        while (!correctChoicePhone1) {
            println("Введено некорректное значение, выберите вариант из предложенного списка")
            listStore[choiceCity.toInt() - 1].pricePrint()
            println("\n0. Вернуться к выбору магазина")
            choicePhone1 = readln()
            correctChoicePhone1 = choicePhone1 in "0"..assortment.size.toString()
        }
        return choicePhone1
    }

    private fun incorrectChoiceCity(correctChoiceCity: Boolean, choiceCity: String): String {
        var correctChoiceCity1 = correctChoiceCity
        var choiceCity1 = choiceCity
        while (!correctChoiceCity1) {
            println("Введено некорректное значение, выберите вариант из предложенного списка")
            println(
                "\"$name!\nВыберете город из которого хотите заказать себе телефон"
            )
            listStorePrint()
            choiceCity1 = readln()
            correctChoiceCity1 = choiceCity1 in "0"..listStore.size.toString()
        }
        return choiceCity1
    }

    private fun inCorrectChoice(correctChoice: Boolean, choice: String): String {
        var correctChoice1 = correctChoice
        var choice1 = choice
        while (!correctChoice1) {
            println("Введено некорректное значение, выберите вариант из предложенного списка")
            println(
                "\n1 - Да\n2 - Нет"
            )
            choice1 = readln()
            correctChoice1 = (choice1 == "1") || (choice1 == "2")
        }
        return choice1
    }

    private fun choiceRepairStore(choiceCity: String) {
        if (listStore[choiceCity.toInt() - 1] == kazan) {
            kazan.phoneWasBeingRepaired = kazan.repairShop(kazan.phoneWasBeingRepaired)
        }
    }

    private fun enterInStore(choiceCity: String) {
        getLine("-")
        if (listStore[choiceCity.toInt() - 1].salesStatisticsStore.isEmpty())
            println(
                "\n${name}!\nВы еще не совершали покупки в магазине " +
                        listStore[choiceCity.toInt() - 1].storeName
            )
        else {
            println(
                "\n${name}!\nС возвращением в магазин " +
                        listStore[choiceCity.toInt() - 1].storeName
            )
            listStore[choiceCity.toInt() - 1].saleStatisticsPrint()
        }
    }

}