object Luhn {
    fun isValid(x: String): Boolean =
        x.replace(" ", "")
            .let { if (it.length <= 1 || !it.all(Char::isDigit)) return false else it }
            .map { it.toString().toInt() }
            .reversed()
            .mapEveryOther {it * 2}
            .mapEveryOther {if (it > 9) it - 9 else it}
            .sum()
            .rem(10) == 0

    fun <T> List<T>.mapEveryOther(transform: (T) -> T): List<T> =
        this.mapIndexed {index, it -> if (index % 2 != 0) transform(it) else it}
}