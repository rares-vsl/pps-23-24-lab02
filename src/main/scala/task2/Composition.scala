package task2

object Composition extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
    println(compose(_ - 1, _ * 2)(5))

    def genericCompose[A, B](f: A => B, g: A =>A): A => B = x => f(g(x))

    val f: Int => String = (x) => x + "."
    val g: Int => Int = _  * 2

    println(genericCompose(f,  g)(5))



