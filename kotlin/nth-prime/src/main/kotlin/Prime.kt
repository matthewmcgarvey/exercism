object Prime {
    fun nth(i: Int): Int {
        require(i > 0) {"There is no zeroth prime."}
        if (i == 1) {
            return 2
        }
        return 3.rangeTo(Int.MAX_VALUE)
            .step(2)
            .asSequence()
            .filter(Int::isPrime)
            .take(i - 1)
            .last()
    }
}

fun Int.isPrime(): Boolean =
    (3..(this / 2))
        .filter { this % it == 0 }
        .isEmpty()