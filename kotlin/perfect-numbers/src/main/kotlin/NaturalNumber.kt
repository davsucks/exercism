enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    val sum = naturalNumber.factorize().sum()
    return when {
        sum == naturalNumber -> Classification.PERFECT
        sum < naturalNumber -> Classification.DEFICIENT
        else -> Classification.ABUNDANT
    }
}

fun Int.factorize(): List<Int> {
    return when {
        this < 1 -> throw RuntimeException("Input must be a natural number")
        else -> (1 until this).filter { this % it == 0 }
    }
}
