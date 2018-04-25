class HandshakeCalculator {
    companion object {
        fun calculateHandshake(input: Int): List<Signal> {
            return input.toBinary().reversed().foldIndexed(listOf()) { index, acc, char ->
                if (char == '1') {
                    val signal = when(index) {
                        0 -> Signal.WINK
                        1 -> Signal.DOUBLE_BLINK
                        2 -> Signal.CLOSE_YOUR_EYES
                        3 -> Signal.JUMP
                        4 -> Signal.REVERSE
                        else -> return listOf()
                    }
                    if (signal == Signal.REVERSE) {
                        return@foldIndexed acc.reversed()
                    }
                    return@foldIndexed acc + signal
                }
                return@foldIndexed acc
            }
        }

        fun Int.toBinary(): String {
            return this.toString(2)
        }
    }
}
