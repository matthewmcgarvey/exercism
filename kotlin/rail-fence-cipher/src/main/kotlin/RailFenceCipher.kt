class RailFenceCipher(val rails: Int) {
    fun getEncryptedData(toEncrypt: String): String =
        toEncrypt
            .toCharArray()
            .zip(oscillating(rails))
            .sortedBy { it.second }
            .map { it.first }
            .joinToString("")

    fun getDecryptedData(encrypted: String): String =
        (0 until encrypted.length)
            .zip(oscillating(rails))
            .sortedBy { it.second }
            .mapIndexed { index, (first, _) -> first to encrypted[index] }
            .sortedBy { it.first }
            .map { it.second }
            .joinToString("")

    private fun oscillating(max: Int): Iterable<Int> {
        val increasing: (Int) -> Int = {x -> x + 1}
        val decreasing: (Int) -> Int = {x -> x - 1}
        var nextFunc: (Int) -> Int = increasing
        return generateSequence(1, {
            if (it == max) {
                nextFunc = decreasing
            } else if (it == 1) {
                nextFunc = increasing
            }
            nextFunc.invoke(it)
        }).asIterable()
    }
}