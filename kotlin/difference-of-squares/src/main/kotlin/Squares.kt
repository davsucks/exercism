class Squares(private val i: Int) {
    private fun Int.squared(): Int = this * this

    fun squareOfSum(): Int = (0..i).sum().squared()

    fun sumOfSquares(): Int = (0..i).reduce { acc, i -> acc + i.squared() }

    fun difference(): Int = squareOfSum() - sumOfSquares()
}

