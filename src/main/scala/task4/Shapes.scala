package task4


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
        