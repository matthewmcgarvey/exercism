class Matrix(val matrix: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate> = rowMaxes.intersect(columnMins)

    private val rowMaxes: Set<MatrixCoordinate>
        get() {
            val results: MutableSet<MatrixCoordinate> = mutableSetOf()
            for ((ri, row) in matrix.withIndex()) {
                val max = row.max()
                for ((ci, x) in row.withIndex()) {
                    if (x == max) {
                        results.add(MatrixCoordinate(ri, ci))
                    }
                }
            }
            return results
        }

    private val columnMins: Set<MatrixCoordinate>
        get() {
            val results: MutableSet<MatrixCoordinate> = mutableSetOf()
            for (i in (0 until matrix.size)) {
                val column = getColumn(i)
                val min = column.min()
                for ((index, x) in column.withIndex()) {
                    if (min == x) {
                        results.add(MatrixCoordinate(index, i))
                    }
                }
            }
            return results
        }

    private fun getColumn(index: Int): List<Int> = matrix.filterNot(List<Int>::isEmpty).map{it.get(index)!!}
}
