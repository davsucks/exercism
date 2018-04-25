class HandshakeCalculator {
    companion object {
        fun calculateHandshake(input: Int): List<Signal> {
            val returnValue = input.toBinary().reversed().asIterable()
                .zip(Signal.values()) { a: Char, b: Signal ->
                    return@zip if (a == '1') b else Signal.NULL
                }.filterNot { Signal.NULL == it }
            return if (returnValue.contains(Signal.REVERSE)) {
                returnValue.minus(Signal.REVERSE).reversed()
            } else {
                returnValue
            }
        }

        fun Int.toBinary(): String {
            return this.toString(2)
        }
    }
}
