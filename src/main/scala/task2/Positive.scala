package task2

object Positive extends App :

    val positive: Int => String = _ match
        case n if n>=0 => "positive"
        case _ => "negative"

    print("val positive")
    println(positive(5))
    println(positive(0))
    println(positive(-5))

    def positive2(n: Int) : String = n match
        case n if n>=0 => "positive"
        case _ => "negative"
    
    print("def positive")
    println(positive2(5))
    println(positive2(0))
    println(positive2(-5))

