object Pangram {
    private val expected = ('a'..'z').joinToString("")
    fun isPangram(test: String): Boolean {
        val actual = test
            .toSet()
            .filter { it.isLetter() }
            .sorted()
            .joinToString("")
            .toLowerCase()
            .toSet()
            .sorted()
            .joinToString("")
        return actual == expected
    }
}
