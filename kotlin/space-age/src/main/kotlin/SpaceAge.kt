import java.math.BigDecimal
import java.math.RoundingMode

val EARTH_YEAR_IN_SECONDS = 31_557_600L

enum class Planets(oribitalPeriodInEarthYears: Double) {
    Earth(1.0),
    Mercury(0.2408467),
    Venus(0.61519726),
    Mars(1.8808158),
    Jupiter(11.862615),
    Saturn(29.447498),
    Uranus(84.016846),
    Neptune(164.79132);

    var periodInSeconds: Double = oribitalPeriodInEarthYears * EARTH_YEAR_IN_SECONDS
}

class SpaceAge(private val age: Long) {
    fun onEarth(): Double = calculateAge(Planets.Earth)
    fun onMercury(): Double = calculateAge(Planets.Mercury)
    fun onVenus(): Double = calculateAge(Planets.Venus)
    fun onMars(): Double = calculateAge(Planets.Mars)
    fun onJupiter(): Double = calculateAge(Planets.Jupiter)
    fun onSaturn(): Double = calculateAge(Planets.Saturn)
    fun onUranus(): Double = calculateAge(Planets.Uranus)
    fun onNeptune(): Double = calculateAge(Planets.Neptune)
    private fun calculateAge(planet: Planets) = (age / planet.periodInSeconds).roundToTwoDecimalPlaces()
}

fun Double.roundToTwoDecimalPlaces(): Double {
    return BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toDouble()
}
