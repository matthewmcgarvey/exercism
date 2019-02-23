object Sieve {
    fun primesUpTo(limit: Int): List<Int> = 
        1.rangeTo(limit).filter(::isPrime)

    fun isPrime(i: Int): Boolean =
        1.rangeTo(i)
            .filter { i % it == 0 }
            .count() == 2
}