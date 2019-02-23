class Triangle(val a: Double, val b: Double, val c: Double) {
    init {
        require(
            a > 0 
            && b > 0 
            && c > 0
            && a + b >= c
            && a + c >= b
            && b + c >= a)
    }

    constructor (a: Int, b: Int, c: Int): 
        this(a.toDouble(), b.toDouble(), c.toDouble())

    val isEquilateral = a == b && a == c
    val isIsosceles = a == b || b == c || a == c
    val isScalene = !isIsosceles
}