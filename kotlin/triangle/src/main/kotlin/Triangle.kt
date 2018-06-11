class Triangle(private val sideOne: Double, private val sideTwo: Double, private val sideThree: Double) {
    constructor(sideOne: Int, sideTwo: Int, sideThree: Int) : this(sideOne.toDouble(), sideTwo.toDouble(), sideThree.toDouble())

    init {
        if (anySideIsZero()) throw IllegalArgumentException("All sides must have length greater than zero")
        if (!triangleInequalityIsPreserved()) throw IllegalArgumentException("Triangle violates triangle inequality")
    }

    val isEquilateral: Boolean = sideOne == sideTwo && sideTwo == sideThree
    val isIsosceles: Boolean = sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree
    val isScalene: Boolean = sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne

    private fun anySideIsZero(): Boolean = sideOne == 0.0 || sideTwo == 0.0 || sideThree == 0.0
    private fun triangleInequalityIsPreserved(): Boolean =
            sideOne + sideTwo > sideThree &&
                    sideOne + sideThree > sideTwo &&
                    sideTwo + sideThree > sideOne
}
