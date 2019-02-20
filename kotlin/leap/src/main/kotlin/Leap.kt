class Year(val year: Int) {
    val isLeap: Boolean
        get() = when {
            year isDivisibleBy 400 -> true
            year isDivisibleBy 100 -> false
            year isDivisibleBy 4 -> true
            else -> false
        }

    infix fun Int.isDivisibleBy(that: Int): Boolean = this.rem(that) == 0
}