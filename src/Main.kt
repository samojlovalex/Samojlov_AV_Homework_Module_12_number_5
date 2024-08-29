//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Сеть магазинов по продаже телефонов")

    val assortment = listOf(
        "Alcatel One Touch 835",
        "Alcatel One Touch 320",
        "Fly M760",
        "Fly Bird S288",
        "LG T510",
        "LG B1300",
        "Maxon MX7970",
        "Maxon MX7920",
        "Motorola V80",
        "Motorola C200",
        "Nokia 7600",
        "Nokia 3310",
        "Panasonic G70",
        "Samsung S300",
        "Samsung X100",
        "Siemens S65",
        "Siemens A60"
    )

    val priceUfa = listOf(
        8870.00,
        1860.00,
        7980.00,
        2470.00,
        6670.00,
        2350.00,
        7220.00,
        4180.00,
        12990.00,
        1800.00,
        12090.00,
        2236.00,
        5630.00,
        7110.00,
        4320.00,
        11080.00,
        2700.00

    )

    val priceKazan = listOf(
        11974.50,
        2511.00,
        10773.00,
        3334.50,
        9004.50,
        3172.50,
        9747.00,
        5643.00,
        17536.50,
        2430.00,
        16321.50,
        3018.60,
        7600.50,
        9598.50,
        5832.00,
        14958.00,
        3645.00
    )
    println(
        "Здравствуйте!\nДля входа в наш интернет магазин требуется регистрация." +
                "\nДля регистрации введите пожалуйста своё имя и придумайте пароль" +
                "\nИмя:"
    )
    val name = readln()
    println("Пароль:")
    val password = readln()
    val onlineStore = OnlineStore(name, assortment, priceUfa, priceKazan)
    onlineStore.openOnlineStore()
}