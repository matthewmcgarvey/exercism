import java.util.*

class Robot {
    var name: String = names.next()

    fun reset() {
        name = names.next()
    }

    companion object {
        private val random = Random()
        private val names = generateSequence { makeName() }.distinct().iterator()

        private fun makeName() = "" + randomChar() + randomChar() + randomNum() + randomNum() + randomNum()

        private fun randomChar() = ('A'..'Z').toList()[random.nextInt(26)]

        private fun randomNum() = random.nextInt(10)
    }
}