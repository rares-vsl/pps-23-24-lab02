package consegna

// Task 1
object Hello extends App:
    println("Hello, Scala")


// Task 2

// ES 3

// a)
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

// b)

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

// c)

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

// Es 4
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

// Es 5

object Composition extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
    println(compose(_ - 1, _ * 2)(5))

    def genericCompose[A, B](f: A => B, g: A =>A): A => B = x => f(g(x))

    val f: Int => String = (x) => x + "."
    val g: Int => Int = _  * 2

    println(genericCompose(f,  g)(5))

// Task 3

object GCD extends App:
    
    @annotation.tailrec 
    def gcd(a: Int, b: Int): Int = (a, b) match
        case (_, 0) if a > 0 => a
        case (a, b) if a > b => gcd(b, a % b)
        case _ => gcd(b, a)

    println(gcd(12, 8))
    println(gcd(14, 7))
    println(gcd(8, 12))

// Task 4

// Test

import org.junit.*
import org.junit.Assert.*
import u02.Values.u

class ShapesTest:
    import task4.Shapes.Shape.*

    val rectangleHeight = 4
    val rectangleWidth = 8

    val circleRadius = 4
    
    val squareSide = 4
    
    val r: Rectangle = Rectangle(rectangleHeight, rectangleWidth)
    val c: Circle   = Circle(circleRadius)
    val s: Square   = Square(squareSide)

    val alpha = 2

    // Perimeter

    @Test def rectanglePerimeter(): Unit = {
        val retanglePerimeter = 2 * (rectangleHeight + rectangleWidth)

        assertEquals(retanglePerimeter, perimeter(r), 0d)
    }

    @Test def circlePerimeter(): Unit = {
        val circlePerimeter = 2*Math.PI*circleRadius

        assertEquals(circlePerimeter, perimeter(c), 0d)
    }

    @Test def squarePerimeter(): Unit = {
        val squarePerimeter = 4 * squareSide

        assertEquals(squarePerimeter, perimeter(s), 0d)
    }

    // Scale

    @Test def rectangleScale(): Unit = {
        val rectangleScaled: Rectangle = Rectangle(alpha*rectangleHeight, alpha * rectangleWidth)
        assertEquals(rectangleScaled, scale(r, alpha))
    }

    @Test def circleScale(): Unit = {
        val circleScaled:Circle = Circle(alpha*circleRadius) 

        assertEquals(circleScaled, scale(c, alpha))
    }

    @Test def squareScale(): Unit = {
        val squareScaled: Square = Square(alpha*squareSide)

        assertEquals(squareScaled, scale(s, alpha))
    }

// Code
object Shapes extends App:
    enum Shape:
        case Rectangle(h: Double, w: Double)
        case Circle(r: Double)
        case Square(s: Double)

    object Shape:
        def perimeter(s: Shape): Double = s match
            case Rectangle(h, w) => 2*(h+w)
            case Circle(r)       => 2*Math.PI*r
            case Square(s)       => 4*s

        def scale(s: Shape, a: Double): Shape = s match
            case Rectangle(h, w) => Rectangle(h*a, w*a)
            case Circle(r)       => Circle(r*a)
            case Square(s)       => Square(s*a)


// Task 5

// Map

import task5.Optionals.Optional
import task5.Optionals.Optional.*

def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Empty() => Empty()
      case Maybe(v) => Maybe(f(v))

def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
      case Maybe(v) if f(v) => Maybe(v)
      case _ => Empty()

import org.junit.*
import org.junit.Assert.*


class OptionalTest:
    @Test def filterShouldKeepTheValueWithSatisfiedCondition(): Unit = {
        assertEquals(Optional.Maybe(5), Optional.filter(Optional.Maybe(5), _ > 2))
    }

    @Test def filterShouldReturnEmptyWithUnsatisfiedCondition(): Unit = {
        assertTrue(Optional.isEmpty(Optional.filter(Optional.Maybe(5), _ > 10)))
    }

    @Test def filterShouldReturnEmptyWhenEmpty(): Unit = {
        assertTrue(Optional.isEmpty(Optional.filter(Optional.Empty[Int](), _ > 1)))
    }