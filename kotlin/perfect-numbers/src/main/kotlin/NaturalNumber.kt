enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0) throw RuntimeException("Input must be a natural number")
    val sum = (1 until naturalNumber).filter { naturalNumber % it == 0 }.sum()
    return when {
        sum == naturalNumber -> Classification.PERFECT
        sum < naturalNumber -> Classification.DEFICIENT
        else -> Classification.ABUNDANT
    }
}
