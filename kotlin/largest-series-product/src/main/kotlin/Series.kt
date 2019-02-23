class Series(val series: String) {
    init {
        require(series.all(Char::isDigit))
    }

    fun getLargestProduct(len: Int): Int =
        series.let { require(it.length >= len); it }
            .let { if (len == 0) return 1 else it }
            .windowed(len)
            .map(this::getProduct)
            .max() ?: Int.MIN_VALUE

    fun getProduct(cs: String): Int =
        cs.map(this::toInt).reduce(Int::times)

    fun toInt(c: Char): Int = c - '0'
}