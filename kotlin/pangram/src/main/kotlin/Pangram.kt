object Pangram {
    fun isPangram(str: String): Boolean = 
        str.filter{ it.isLetter() }
            .toLowerCase()
            .toSet()
            .size == 26
}