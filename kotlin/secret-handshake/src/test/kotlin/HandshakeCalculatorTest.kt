import HandshakeCalculator.Companion.toBinary
import org.junit.Test
import kotlin.test.assertEquals

class HandshakeCalculatorTest {
    @Test
    fun testThatInput1YieldsAWink() {
        assertEquals(
            listOf(Signal.WINK),
            HandshakeCalculator.calculateHandshake(1)
        )
    }

    @Test
    fun testThatInput2YieldsADoubleBlink() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(2)
        )
    }

    @Test
    fun testThatInput4YieldsACloseYourEyes() {
        assertEquals(
            listOf(Signal.CLOSE_YOUR_EYES),
            HandshakeCalculator.calculateHandshake(4)
        )
    }

    @Test
    fun testThatInput8YieldsAJump() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(8)
        )
    }

    @Test
    fun testAnInputThatYieldsTwoActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(3)
        )
    }

    @Test
    fun testAnInputThatYieldsTwoReversedActions() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(19)
        )
    }

    @Test
    fun testReversingASingleActionYieldsTheSameAction() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(24)
        )
    }

    @Test
    fun testReversingNoActionsYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(16)
        )
    }

    @Test
    fun testInputThatYieldsAllActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),
            HandshakeCalculator.calculateHandshake(15)
        )
    }

    @Test
    fun testInputThatYieldsAllActionsReversed() {
        assertEquals(
            listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(31)
        )
    }

    @Test
    fun testThatInput0YieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(0)
        )
    }

    @Test
    fun testThatInputWithLower5BitsNotSetYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(32)
        )
    }

    @Test
    fun itConverts0ToBinary() {
        assertEquals("0", 0.toBinary())
    }

    @Test
    fun itConverts1ToBinary() {
        assertEquals("1", 1.toBinary())
    }

    @Test
    fun itConverts15ToBinary() {
        assertEquals("1111", 15.toBinary())
    }

    @Test
    fun itReturnsSignalValuesInTheExpectedOrder() {
        assertEquals(
            listOf(
                Signal.WINK,
                Signal.DOUBLE_BLINK,
                Signal.CLOSE_YOUR_EYES,
                Signal.JUMP,
                Signal.REVERSE,
                Signal.NULL
            ), Signal.values().asList()
        )
    }
}
