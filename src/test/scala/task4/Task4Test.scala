package task4

import org.junit.*
import org.junit.Assert.*
import task4.Shape.*

class Task3Test:

    @Test 
    def testPerimeters(): Unit = {
        val base = 4
        val height = 5
        val r = 3
        val l = 2

        assertEquals(2 * (base + height), perimeter(Rectangle(base, height)), 1.0) // 5.0 because delta is required with double values.
        assertEquals(2 * Math.PI * r, perimeter(Circle(r)), 1.0)
        assertEquals(4 * l, perimeter(Square(l)), 1.0)
    }

    @Test 
    def testScales(): Unit = {
        val initialDimension = 3
        val alpha = 2
        val rectangle = Rectangle(initialDimension, initialDimension)
        val circle = Circle(initialDimension)
        val square = Square(initialDimension)

        assertEquals(Rectangle(initialDimension * alpha, initialDimension * alpha), scale(rectangle, alpha))
        assertEquals(Circle(initialDimension * alpha), scale(circle, alpha))
        assertEquals(Square(initialDimension * alpha), scale(square, alpha))
    }


