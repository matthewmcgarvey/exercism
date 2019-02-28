class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        val position = c - 'A'
        val y =  ('A'..c)
            .map(Char::toString)
            .mapIndexed {index, x -> if (index > 0) x.padEnd(x.length + nthOdd(index)) + x else x }
            .mapIndexed {index, x -> x.padStart(x.length + position - index) }
            .mapIndexed {index, x -> x.padEnd(x.length + position - index)}
        return y + y.reversed().drop(1)
    }

    fun nthOdd(nth: Int): Int {
        return (1..Int.MAX_VALUE)
            .step(2)
            .take(nth)
            .last()
    }
}
