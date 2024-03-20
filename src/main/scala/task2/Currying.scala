package task2

object Currying extends App:
    // Curried val
    val p1: Int => Int => Int => Boolean = x => y => z => x<= y && y == z
  //val p1 = (x: Int) => (y: Int) => (z: Int) => x<= y && y == z

    println("p1")
    println(p1(1)(2)(2)) // true
    println(p1(1)(2)(5)) // false
    println(p1(4)(2)(2)) // false
    println()
    
    // Non-curried val 
    val p2: (Int, Int, Int) => Boolean = (x, y, z) => x<= y && y == z
  //val p2 = (x: Int, y: Int, z: Int) => x <= y && y == z

    println("p2")
    println(p2(1,2,2))
    println(p2(1,2,5))
    println(p2(4,2,2))
    println()
    
    //Curried  def
    def p3(x: Int)(y: Int)(z: Int): Boolean = x<= y && y == z
    
    println("p3")
    println(p3(1)(2)(2))
    println(p3(1)(2)(5))
    println(p3(4)(2)(2))
    println()
    // Non-curried def 
    def p4 (x: Int, y: Int, z:Int): Boolean = x<= y && y == z
    
    println("p4")
    println(p4(1,2,2))
    println(p4(1,2,5))
    println(p4(4,2,2))