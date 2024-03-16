package task4

import u02.CaseMatch.res

enum Shape:
    case Rectangle(a: Double, b: Double)
    case Circle(r: Double)
    case Square(l: Double)

object Shape:
    def perimeter(shape: Shape): Double = shape match
        case Rectangle(a, b) => a * 2 + b * 2
        case Circle(r) => 2 * Math.PI * r
        case Square(l) => l * 4

    def scale(shape: Shape, alpha: Double): Shape = shape match
        case Rectangle(a, b) => Rectangle(a * alpha, b * alpha)
        case Circle(r) => Circle(r * alpha)
        case Square(l) => Square(l * alpha)
    

    

