package task2

object GenericNegative extends App:
    val empty: String => Boolean = _ == "" // predicate on strings
    val postitive: Int => Boolean = _ >= 0 // predicate on int

    def neg[A](p: A => Boolean) : A => Boolean = !p(_)

    val notEmpty = neg(empty) // which type of notEmpty?
    val notPositive = neg(postitive) // which type of notEmpty?

    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notPositive(5)) // false
    println(notPositive(-5)) // true