object Pangram {
    private const val alphabetSize = 26
    fun isPangram(test: String): Boolean = test
        .toLowerCase()
        .toSet()
        .filter { it.isLetter() }
        .size == alphabetSize
}
