
object PrimeFactorCalculator {
    fun primeFactors(input: Int): List<Int> {
        return primeFactors(input.toLong()).map(Long::toInt)
    }

    fun primeFactors(input: Long): List<Long> {
        var temp = input
        val factors = mutableListOf<Long>()
        while (temp != 1L) {
            if (temp % 2 == 0L) {
                factors.add(2)
                temp /= 2
                continue
            }
            for (i in 3..temp step 2) {
                if (temp % i == 0L) {
                    temp /= i
                    factors.add(i)
                    break
                }
            }
        }
        return factors.toList()
    }
}