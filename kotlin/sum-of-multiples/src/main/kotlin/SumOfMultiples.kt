import kotlin.coroutines.experimental.buildIterator

object SumOfMultiples {
    fun sum(multiples: Set<Int>, exclusiveMax: Int): Int =
        multiples.flatMap { multiplesOf(it) `lessThan` exclusiveMax}
                .toSet()
                .sum()
    
    private fun multiplesOf(i: Int): Iterator<Int> = 
        buildIterator {
            var counter = 1
            while(true) {
                yield(i * counter)
                counter++
            }
        }

    private infix fun Iterator<Int>.lessThan(exclusiveMax: Int): List<Int> {
        val found: MutableList<Int> = mutableListOf()
        for(i in this) {
            if (i >= exclusiveMax) {
                return found
            }
            found.add(i)
        }
        return found
    }
}