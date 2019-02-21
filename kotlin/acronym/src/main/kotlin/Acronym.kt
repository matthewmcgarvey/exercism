object Acronym {
    fun generate(phrase: String): String = 
        phrase.split(" ", "-")
            .filter(String::isNotBlank)
            .map { it.first().toUpperCase() }
            .joinToString("")
}