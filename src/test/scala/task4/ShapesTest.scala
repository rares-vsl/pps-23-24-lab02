package task4

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



    