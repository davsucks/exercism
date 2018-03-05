import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(private val age: Long) {
    fun onEarth(): Double = onEarthBeforeRounding().roundToTwoDecimalPlaces()
    fun onMercury(): Double = onEarthBeforeRounding().div(0.2408467).roundToTwoDecimalPlaces()
    fun onVenus(): Double = onEarthBeforeRounding().div(0.61519726).roundToTwoDecimalPlaces()
    fun onMars(): Double = onEarthBeforeRounding().div(1.8808158).roundToTwoDecimalPlaces()
    fun onJupiter(): Double = onEarthBeforeRounding().div(11.862615).roundToTwoDecimalPlaces()
    fun onSaturn(): Double = onEarthBeforeRounding().div(29.447498).roundToTwoDecimalPlaces()
    fun onUranus(): Double = onEarthBeforeRounding().div(84.016846).roundToTwoDecimalPlaces()
    fun onNeptune(): Double = onEarthBeforeRounding().div(164.79132).roundToTwoDecimalPlaces()

    private fun onEarthBeforeRounding() = this.age.toDouble() / EARTH_YEAR_IN_SECONDS.toDouble()

    private fun Double.roundToTwoDecimalPlaces(): Double {
        return BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    private val EARTH_YEAR_IN_SECONDS = 31_557_600L
}
