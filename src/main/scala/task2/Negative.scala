package task2

object Negative extends App:
    
    val empty: String => Boolean = _ == "" // predicate on strings

    val neg: (String => Boolean) => (String => Boolean) = pred => !pred(_)

    val notEmpty = neg(empty) // which type of notEmpty?
    println("val style")
    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notEmpty("foo") && !notEmpty("") )// true.. a comprehensive test */

    println("def style")

    def neg2(p: String => Boolean) : String => Boolean = !p(_)

    val notEmpty2 = neg2(empty) // which type of notEmpty?
    println("val style")
    println(notEmpty2("foo")) // true
    println(notEmpty2("")) // false
    println(notEmpty2("foo") && !notEmpty2("") )// true.. a comprehensive test */