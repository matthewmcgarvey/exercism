object ScrabbleScore {
    fun scoreWord(word: String): Int = word.toUpperCase().sumBy(this::scoreChar)

    private fun scoreChar(char: Char): Int = 
        when(char) {
            in "AEIOULNRST" -> 1
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            'K' -> 5
            in "JX" -> 8
            in "QZ" -> 10
            else -> throw IllegalStateException("an invalid char was passed: ${char}")
        }
}