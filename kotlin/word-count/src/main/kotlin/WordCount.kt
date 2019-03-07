object WordCount {
    fun phrase(str: String): Map<String, Int> {
        return str.split(' ', ',')
            .map {it.filter {it.isLetterOrDigit() || it == '\''}}
            .map {it.trimStart('\'')}
            .map {it.trimEnd('\'')}
            .filterNot(String::isBlank)
            .map(String::toLowerCase)
            .groupingBy {it}
            .eachCount()
    }
}