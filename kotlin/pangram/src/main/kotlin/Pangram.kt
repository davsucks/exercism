class Pangram {
    companion object {
        private val expected = "abcdefghijklmnopqrstuvwxyz"
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
}
