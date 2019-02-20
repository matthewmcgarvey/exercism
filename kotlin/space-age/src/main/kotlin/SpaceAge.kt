import kotlin.math.*

class SpaceAge(val age: Long) {
    fun onEarth(): Double = round2(onEarth_())
    fun onMercury(): Double = ageComparedToEarth(0.2408467)
    fun onVenus(): Double = ageComparedToEarth(0.61519726)
    fun onMars(): Double = ageComparedToEarth(1.8808158)
    fun onJupiter(): Double = ageComparedToEarth(11.862615)
    fun onSaturn(): Double = ageComparedToEarth(29.447498)
    fun onUranus(): Double = ageComparedToEarth(84.016846)
    fun onNeptune(): Double = ageComparedToEarth(164.79132)

    private fun ageComparedToEarth(orbitalPeriod: Double): Double =
        round2(onEarth_() / orbitalPeriod)

    private fun onEarth_(): Double = age / 31557600.0

    private fun round2(init: Double): Double = round(init * 100) / 100
}