package task3

object GCD extends App:
    
    @annotation.tailrec 
    def gcd(a: Int, b: Int): Int = (a, b) match
        case (_, 0) if a > 0 => a
        case (a, b) if a > b => gcd(b, a % b)
        case _ => gcd(b, a)

    println(gcd(12, 8))
    println(gcd(14, 7))
    println(gcd(8, 12))




