package task3

object Task3 extends App:
    def gcd(a: Int, b: Int): Int = (a, b) match
        case (a, b) if b > a => gcd(b, a)
        case (a, b) if b != 0 => gcd(b, a % b)
        case (_, 0) => a