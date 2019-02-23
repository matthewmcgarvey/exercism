object Atbash {
    val cypher: Map<Char, Char> = ('a'..'z').zip('z' downTo 'a').toMap()
    fun encode(input: String): String =
        input.filter(Char::isLetterOrDigit)
            .toLowerCase()
            .map { cypher.getOrDefault(it, it) }
            .joinToString("")
            .chunked(5)
            .joinToString(" ")

    fun decode(input: String): String =
        input.replace(" ", "")
            .map { cypher.getOrDefault(it, it) }
            .joinToString("")
}