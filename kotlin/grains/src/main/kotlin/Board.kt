import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(square: Int): BigInteger {
        require(square in 1..64) {"Only integers between 1 and 64 (inclusive) are allowed"}
        return 1.rangeTo(square).map(Int::toBigInteger).reduce {acc, _ -> acc.times(BigInteger.valueOf(2))}
    }

    fun getTotalGrainCount(): BigInteger =
        1.rangeTo(64).map(::getGrainCountForSquare).sum()

    private fun List<BigInteger>.sum(): BigInteger =
        this.reduce {acc, curr -> acc.plus(curr)}
}