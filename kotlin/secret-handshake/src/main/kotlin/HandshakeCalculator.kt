class HandshakeCalculator {
    companion object {
        fun calculateHandshake(input: Int): List<Signal> {
            return input
                .toBinary()
                .reversed()
                .asIterable()
                .zip(Signal.values()) { bit, signal -> if (bit.isActive()) signal else Signal.NULL }
                .filterNot { Signal.NULL == it }
                .branch(
                    predicate = { it.contains(Signal.REVERSE) },
                    leftOperation = { it.minus(Signal.REVERSE).reversed() },
                    rightOperation = { it })
        }

        fun Int.toBinary(): String = this.toString(2)

        private fun <T> T.branch(
            predicate: (T) -> Boolean,
            leftOperation: (T) -> T,
            rightOperation: (T) -> T
        ): T = if (predicate(this)) leftOperation(this) else rightOperation(this)

        private fun Char.isActive(): Boolean = this == '1'
    }
}
