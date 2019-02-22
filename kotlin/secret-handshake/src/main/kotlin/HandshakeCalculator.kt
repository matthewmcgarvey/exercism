object HandshakeCalculator {
    fun calculateHandshake(num: Int): List<Signal> =
        when {
            num >= 16 -> calculateHandshake(num - 16).reversed()
            num >= 8 ->  calculateHandshake(num - 8) + listOf(Signal.JUMP)
            num >= 4 ->  calculateHandshake(num - 4) + listOf(Signal.CLOSE_YOUR_EYES)
            num >= 2 ->  calculateHandshake(num - 2) + listOf(Signal.DOUBLE_BLINK)
            num >= 1 -> listOf(Signal.WINK)
            else -> emptyList()
        }
}