object Bob {
    fun hey(msg: String): String =
        when {
            isForcefulQuestion(msg) -> "Calm down, I know what I'm doing!"
            isYelling(msg) -> "Whoa, chill out!"
            isQuestion(msg) -> "Sure."
            isSilence(msg) -> "Fine. Be that way!"
            else -> "Whatever."
        }

    private fun isForcefulQuestion(msg: String): Boolean =
        isYelling(msg) && isQuestion(msg)

    private fun isYelling(msg: String): Boolean =
        msg.toUpperCase() == msg && msg.toLowerCase() != msg

    private fun isQuestion(msg: String): Boolean =
        msg.trimEnd().endsWith("?")

    private fun isSilence(msg: String): Boolean =
        msg.isBlank()
}
