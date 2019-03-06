class Dna(private val strand: String) {
    private val NUCLEOTIDES = "ACGT"

    init {
        require(strand.all { it in NUCLEOTIDES })
    }

    val nucleotideCounts: Map<Char, Int> =
        NUCLEOTIDES.map { it to strand.occurrencesOf(it) }.toMap()

    private fun String.occurrencesOf(c: Char): Int = count { it == c }
}