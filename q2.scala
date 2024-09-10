object RationalExample extends App {
    class Rational(n : Int, d : Int){
        require( d != 0 , "Denominator must not be zero")
        private val gcdValue = gcd(n.abs, d.abs)
        val numerator : Int = n / gcdValue
        val denominator : Int = d / gcdValue

        def neg: Rational =  new Rational (-numerator, denominator)

        def sub( that : Rational ) : Rational = {
            val newNumerator = this.numerator * that.denominator  - this.denominator * that.numerator
            val newDenominator = this.denominator * that.denominator
            new Rational(newNumerator, newDenominator)
        }
        override def toString: String = s" $numerator / $denominator "

        private def gcd (a: Int, b: Int) : Int = if (b==0){
             a 
            } else {
                gcd ( b , a % b)
            }
    }
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result1 = y.sub(z)

    val result2 = x.sub(result1)
    println("\n")
    println(s"x - (y - 2) is : $result2")
    println('\n')
}
