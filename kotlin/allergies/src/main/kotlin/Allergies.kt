
class Allergies(val score: Int) {
    fun isAllergicTo(allergen: Allergen): Boolean =
        (score and allergen.score) == allergen.score

    fun getList(): List<Allergen> =
        Allergen.values().filter(::isAllergicTo)
}