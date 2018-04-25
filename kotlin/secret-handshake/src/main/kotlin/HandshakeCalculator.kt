class HandshakeCalculator {
    companion object {
        fun calculateHandshake(input: Int): List<Signal> {
            return input
                .toBinary()
                .reversed()
                .asIterable()
                .zip(Signal.values()) { char, signal -> if (char == '1') signal else Signal.NULL }
                .filterNot { Signal.NULL == it }
                .branch(
                    predicate = { it.contains(Signal.REVERSE) },
                    leftOperation = { it.minus(Signal.REVERSE).reversed() },
                    rightOperation = { it })
        }

        fun Int.toBinary(): String {
            return this.toString(2)
        }

        private fun List<Signal>.branch(
            predicate: (List<Signal>) -> Boolean,
            leftOperation: (List<Signal>) -> List<Signal>,
            rightOperation: (List<Signal>) -> List<Signal>
        ): List<Signal> {
            return if (predicate(this)) leftOperation(this) else rightOperation(this)
        }
    }
}
