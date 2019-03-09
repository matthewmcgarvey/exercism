import kotlin.coroutines.experimental.buildSequence

object SpiralMatrix {
    fun ofSize(size: Int): Array<IntArray> {
        val sizeList = (1..size).toList()
        val matrix = sizeList.map { mutableListOf(*sizeList.toTypedArray()) }
        (1..(size * size))
                .zip(coordinates(size).asIterable())
                .forEach {
                    matrix[it.second.second][it.second.first] = it.first
                }
        return matrix.map { it.toIntArray() }.toTypedArray()
    }

    private fun coordinates(size: Int): Sequence<Pair<Int, Int>> {
        return buildSequence {
            var right = true
            var up = false
            var vertical = true
            var point = Pair(0, 0)
            val points = mutableSetOf(point)
            yield(point)

            while (true) {
                if (vertical) {
                    if (right) {
                        point = point.right()
                        if (points.contains(point.right()) || point.right().first == size) {
                            right = false
                            vertical = false
                            up = false
                        }
                    } else {
                        point = point.left()
                        if (points.contains(point.left()) || point.left().first < 0) {
                            right = true
                            vertical = false
                            up = true
                        }
                    }
                } else {
                    if (up) {
                        point = point.up()
                        if (points.contains(point.up())) {
                            right = true
                            vertical = true
                            up = false
                        }
                    } else {
                        point = point.down()
                        if (points.contains(point.down()) || point.down().second == size) {
                            right = false
                            vertical = true
                            up = true
                        }
                    }
                }
                points.add(point)
                yield(point)
            }
        }
    }

    private fun Pair<Int, Int>.right(): Pair<Int, Int> = copy(first = first + 1)
    private fun Pair<Int, Int>.left(): Pair<Int, Int> = copy(first = first - 1)
    private fun Pair<Int, Int>.up(): Pair<Int, Int> = copy(second = second - 1)
    private fun Pair<Int, Int>.down(): Pair<Int, Int> = copy(second = second + 1)
}
