object Luhn {
    fun isValid(input: String): Boolean {
        val filteredInput = input.filterNot(Char::isWhitespace)
        return when {
            filteredInput.length < 2 -> false
            filteredInput.any { it.isNotDigit() } -> false
            else -> filteredInput
                    .map(Character::getNumericValue)
                    .reversed()
                    .reduceIndexed { index: Int, acc: Int, i: Int ->
                        if (index.isOdd()) {
                            val iDoubled = i * 2
                            if (iDoubled > 9) return@reduceIndexed acc + (iDoubled - 9)
                            else return@reduceIndexed acc + iDoubled
                        } else return@reduceIndexed acc + i
                    }.isDivisibleByTen()
        }
    }

    private fun Char.isNotDigit(): Boolean = !this.isDigit()
    private fun Int.isOdd(): Boolean = this % 2 == 1
    private fun Int.isDivisibleByTen(): Boolean = this % 10 == 0
}

