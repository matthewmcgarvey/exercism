object CollatzCalculator {
    fun computeStepCount(init: Int): Int {
        require(init > 0) {"Only natural numbers are allowed"}
        return generateSequence(init, ::nextStep).takeWhile{it > 1}.count()
    }

    fun nextStep(curr: Int): Int =
        if (curr % 2 == 0) curr.div(2) else curr.times(3).plus(1)
}