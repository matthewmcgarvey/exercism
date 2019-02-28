object Isogram {
    fun isIsogram(input: String): Boolean =
        input.toLowerCase()
            .filter(Char::isLetter)
            .run { toSet().size == length }
}