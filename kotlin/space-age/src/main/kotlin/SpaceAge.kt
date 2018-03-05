import java.math.BigDecimal
import java.math.RoundingMode

val EARTH_YEAR_IN_SECONDS = 31_557_600L

enum class Planets(period: Double) {
    Earth(1.0),
    Mercury(0.2408467),
    Venus(0.61519726),
    Mars(1.8808158),
    Jupiter(11.862615),
    Saturn(29.447498),
    Uranus(84.016846),
    Neptune(164.79132);

    var periodInSeconds: Double = period * EARTH_YEAR_IN_SECONDS
}

class SpaceAge(private val age: Long) {
    fun onEarth(): Double = (age / Planets.Earth.periodInSeconds).roundToTwoDecimalPlaces()
    fun onMercury(): Double = (age / Planets.Mercury.periodInSeconds).roundToTwoDecimalPlaces()
    fun onVenus(): Double = (age / Planets.Venus.periodInSeconds).roundToTwoDecimalPlaces()
    fun onMars(): Double = (age / Planets.Mars.periodInSeconds).roundToTwoDecimalPlaces()
    fun onJupiter(): Double = (age / Planets.Jupiter.periodInSeconds).roundToTwoDecimalPlaces()
    fun onSaturn(): Double = (age / Planets.Saturn.periodInSeconds).roundToTwoDecimalPlaces()
    fun onUranus(): Double = (age / Planets.Uranus.periodInSeconds).roundToTwoDecimalPlaces()
    fun onNeptune(): Double = (age / Planets.Neptune.periodInSeconds).roundToTwoDecimalPlaces()
}

fun Double.roundToTwoDecimalPlaces(): Double {
    return BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toDouble()
}
