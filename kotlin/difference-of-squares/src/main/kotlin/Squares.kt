class Squares(private val value: Int) {
    fun squareOfSum(): Int = (1..value).sum().squared()
    fun sumOfSquares(): Int = (1..value).map(Int::squared).sum()
    fun difference(): Int = squareOfSum() - sumOfSquares()
}

private fun Int.squared() = this * this