object Hamming {
    fun compute(a: String, b: String): Int {
        if (a.length != b.length)
            throw IllegalArgumentException("left and right strands must be of equal length.")
        return a.zip(b)
            .filter { it.first != it.second }
            .size
    }
}