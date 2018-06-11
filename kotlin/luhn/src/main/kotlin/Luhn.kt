object Luhn {
    fun isValid(input: String): Boolean {
        val filteredInput = input.filterNot(Char::isWhitespace)
        return when {
            filteredInput.length < 2 -> false
            filteredInput.any { it.isNotDigit() } -> false
            else -> filteredInput
                    .map(Character::getNumericValue)
                    .reversed()
                    .doubleEveryOtherDigit()
                    .sum()
                    .isDivisibleByTen()
        }
    }

    private fun Char.isNotDigit(): Boolean = !this.isDigit()
    private fun Int.isOdd(): Boolean = this % 2 == 1
    private fun Int.isDivisibleByTen(): Boolean = this % 10 == 0
    private fun List<Int>.doubleEveryOtherDigit(): List<Int> = this.mapIndexed { index, i ->
        if (index.isOdd()) {
            val doubled = i * 2
            if (doubled > 9) return@mapIndexed doubled - 9
            else return@mapIndexed doubled
        } else return@mapIndexed i
    }
}

