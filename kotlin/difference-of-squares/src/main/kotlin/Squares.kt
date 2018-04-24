class Squares(private val i: Int) {
    private fun Int.squared(): Int {
        return this * this
    }

    fun squareOfSum(): Int {
        return (0..i).sum().squared()
    }

    fun sumOfSquares(): Int {
        return (0..i).reduce { acc, i -> acc + i.squared() }
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}

