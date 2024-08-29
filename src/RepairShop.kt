interface RepairShop {
    fun repairShop(phoneWasBeingRepaired: Boolean): Boolean {
        var repairPhone = phoneWasBeingRepaired
        if (phoneWasBeingRepaired) println("\nВаш телефон был ранее отремонтирован в нашей мастерской")
        else {
            println("\nВ нашем магазине имеется мастерская по ремонту телефонов.\n" +
                    "Отремонтировать ваш телефон в нашей мастерской?\n1. Да\n2. Нет")
            var choice = readln()
            var correctChoice = (choice == "1") || (choice == "2")

            while (!correctChoice) {
                println("\nВведено некорректное значение, выберите вариант из предложенного списка")
                println("Отремонтировать ваш телефон в нашей мастерской?\n1. Да\n2. Нет")
                choice = readln()
                correctChoice = (choice == "1") || (choice == "2")
            }

            if (choice == "1") {
                println("Телефон отремонтирован")
                repairPhone = true
            } else {
                println("Наша мастерская всегда к вашим услугам при необходимости")
            }
        }
        getLine("-")
        return repairPhone
    }
}