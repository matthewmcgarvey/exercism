object PascalsTriangle {
    fun computeTriangle(input: Int): List<List<Int>> {
        require(input >= 0) { "Rows can't be negative!" }
        return generateSequence(listOf(1), ::nextRow)
            .take(input)
            .toList()
    }

    private fun nextRow(prev: List<Int>): List<Int> =
        (0..prev.size).map { diagonalSum(it, prev) }

    private fun diagonalSum(index: Int, prev: List<Int>): Int =
        prev.getOrElse(index.dec()) {0} + prev.getOrElse(index) {0}
}