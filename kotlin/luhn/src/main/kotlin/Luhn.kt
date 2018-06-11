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
        return@mapIndexed when {
            index.isOdd() -> i.singleDigitDouble()
            else -> i
        }
    }
    private fun Int.singleDigitDouble(): Int {
        val doubled = this * 2
        return when {
            doubled > 9 -> doubled - 9
            else -> doubled
        }
    }
}

