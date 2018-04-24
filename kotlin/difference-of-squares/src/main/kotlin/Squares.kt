class Squares(i: Int) {
    private val range = 0..i
    private fun Int.squared(): Int = this * this

    fun squareOfSum(): Int = range.sum().squared()

    fun sumOfSquares(): Int = range.reduce { acc, i -> acc + i.squared() }

    fun difference(): Int = squareOfSum() - sumOfSquares()
}
