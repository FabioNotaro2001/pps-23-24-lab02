import org.junit.*
import org.junit.Assert.*
import Task2a.positive
import Task2a.positiveMethod
import task2.Task2b.neg
import task2.Task2c.genericNeg
import task2.Task2d.p1
import task2.Task2d.p2
import task2.Task2d.p3
import task2.Task2d.p4
import task2.Task2e.compose
import task2.Task2e.genericCompose
import task3.Task3.gcd
import task4.Shape.perimeter
import task4.Shape.scale
import task5.Optionals.Optional
import task5.Optionals.Optional.filter

// Tutti i task sono stati svolti da solo.

// Task 1.
object HelloWorld extends App:
    println("Hello, Scala!")

// Task 2a.
object Task2a extends App:
    val positive: Int => String = _ match
        case p if p >= 0 => "positive"
        case _ => "negative"

    def positiveMethod(n: Int): String = n match
        case p if p >= 0 => "positive"
        case _ => "negative"

class Task2aTest:
    @Test 
    def testPositiveValWithActualPositive(): 
        assertEquals("positive", positive(10))

    @Test 
    def testPositiveValWithActualNegative(): 
        assertEquals("negative", positive(-10))

    @Test 
    def testPositiveValWithInconsistence():
        assertNotEquals("positive", positive(-10))

    @Test 
    def testpositiveDefWithActualPositive(): 
        assertEquals("positive", positiveMethod(10))

    @Test 
    def testPositiveDefWithActualNegative(): 
        assertEquals("negative", positiveMethod(-10))

    @Test 
    def testPositiveDefWithInconsistence(): 
        assertNotEquals("positive", positiveMethod(-10))

// Task2b.
object Task2b extends App:
    def neg(predicate: String => Boolean): String => Boolean = 
        givenString => !predicate(givenString)

class Task2bTest:
    @Test 
    def testNegWithNonEmptyString(): 
        val isEmptyString: String => Boolean = _ == ""
        val isNotEmptyString = neg(isEmptyString)
        assertTrue(isNotEmptyString("String"))
        assertFalse(isNotEmptyString(""))

    @Test 
    def testNegWithShortString():
        val isShortString: String => Boolean = givenString => givenString.length() <= 4
        val isNotShortString = neg(isShortString)
        assertTrue(isNotShortString("Very-long string"))
        assertFalse(isNotShortString("ab"))

// Task 2c.
object Task2c extends App:
    def genericNeg[X] (predicate: X => Boolean): X => Boolean = 
        givenElement => !predicate(givenElement)

class Task2cTest:
    @Test 
    def testNegWithStringType(): 
        val isEmptyString: String => Boolean = _ == ""
        val isNotEmptyString = genericNeg(isEmptyString)
        assertTrue(isNotEmptyString("String"))
        assertFalse(isNotEmptyString(""))

    @Test 
    def testNegWithIntType(): 
        val isEvenNumber: Int => Boolean = number => number % 2 == 0
        val isNotEvenNumber = genericNeg(isEvenNumber)
        assertTrue(isNotEvenNumber(3))
        assertFalse(isNotEvenNumber(2))

// Task 2d.
object Task2d extends App:
    val p1: Double => Double => Double => Boolean = x => y => z => x <= y && y == z

    val p2: (Double, Double, Double) =>  Boolean =
        (x, y, z) => x <= y && y == z

    def p3(x: Double)(y: Double)(z: Double): Boolean = x <= y && y == z

    def p4(x: Double, y: Double, z: Double): Boolean = x <= y && y == z

class Task2dTest:
    @Test 
    def testp1(): 
        assertTrue(p1(3)(10)(10))
        assertFalse(p1(3)(11)(10))
        assertFalse(p1(12)(5)(5))

    @Test 
    def testp2(): 
        assertTrue(p2(3, 10, 10))
        assertFalse(p2(3, 11, 10))
        assertFalse(p2(12, 5, 5))

    @Test 
    def testp3(): 
        assertTrue(p3(3)(10)(10))
        assertFalse(p3(3)(11)(10))
        assertFalse(p3(12)(5)(5))

    @Test 
    def testp4(): 
        assertTrue(p4(3, 10, 10))
        assertFalse(p4(3, 11, 10))
        assertFalse(p4(12, 5, 5))

// Task 2e.
object Task2e extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

    // Note the constraint about type relationships between f and g types.
    def genericCompose[X, Y, Z](f: Y => Z, g: X => Y): X => Z =
      x => f(g(x))

class Task2eTest:
    @Test 
    def testComposeWithInt():
        assertEquals(9, compose(_-1, _*2)(5))
        assertEquals(2, compose(_+1, _-1)(2))
        assertEquals(80, compose(_*2, _-10)(50))

    @Test 
    def testGenericComposeWithInt(): 
        def double: Int => Int = number => number * 2
        def increment: Int => Int = number => number + 1
        assertEquals(12, genericCompose(double(_), increment(_))(5))

    @Test 
    def testGenericComposeWithString(): 
        def concatenate(initialPart: String, finalPart: String): String = initialPart + finalPart
        assertEquals("PrimaPoiInfine", genericCompose(concatenate(_, "Infine"), concatenate(_, "Poi"))("Prima"))

    @Test 
    def testGenericComposeWithIntAndString(): 
        def convertNumberToString: Integer => String = number => "Number: " + number
        def checkEvenNumberOfChar: String => Boolean = givenString => givenString.length() % 2 == 0
        assertTrue(genericCompose(checkEvenNumberOfChar(_), convertNumberToString(_))(10))
        assertFalse(genericCompose(checkEvenNumberOfChar(_), convertNumberToString(_))(1))

// Task 3.
object Task3 extends App:
    def gcd(a: Int, b: Int): Int = (a, b) match
        case (a, b) if b > a => gcd(b, a)
        case (a, b) if b != 0 => gcd(b, a % b)
        case (_, 0) => a

class Task3Test:
    @Test 
    def testGCDWithEasyCase(): 
        assertEquals(10, gcd(100, 30))

    @Test 
    def testGCDWithSwitchedNumbers():
        assertEquals(5, gcd(5, 10))

    @Test 
    def testGCDWithPrimeNumbers(): 
        assertEquals(1, gcd(7, 3))

// Task 4.
enum Shape:
    case Rectangle(a: Double, b: Double)
    case Circle(r: Double)
    case Square(l: Double)

object Shape:
    def perimeter(s: Shape): Double = s match
        case Rectangle(a, b) => a * 2 + b * 2
        case Circle(r) => 2 * Math.PI * r
        case Square(l) => l * 4

    def scale(s: Shape, alpha: Double): Shape = s match
        case Rectangle(a, b) => Rectangle(a * alpha, b * alpha)
        case Circle(r) => Circle(r * alpha)
        case Square(l) => Square(l * alpha)

class Task4Test:
    @Test 
    def testPerimeters():
        val base = 4
        val height = 5
        val r = 3
        val l = 2
        assertEquals(2 * (base + height), perimeter(task4.Shape.Rectangle(base, height)), 1.0) // 5.0 because delta is required with double values.
        assertEquals(2 * Math.PI * r, perimeter(task4.Shape.Circle(r)), 1.0)
        assertEquals(4 * l, perimeter(task4.Shape.Square(l)), 1.0)

    @Test 
    def testScales(): 
        val initialDimension = 3
        val alpha = 2
        val rectangle = task4.Shape.Rectangle(initialDimension, initialDimension)
        val circle = task4.Shape.Circle(initialDimension)
        val square = task4.Shape.Square(initialDimension)
        assertEquals(task4.Shape.Rectangle(initialDimension * alpha, initialDimension * alpha), scale(rectangle, alpha))
        assertEquals(task4.Shape.Circle(initialDimension * alpha), scale(circle, alpha))
        assertEquals(task4.Shape.Square(initialDimension * alpha), scale(square, alpha))

// Task 5.
object Optionals:
  /**
   * Optional is a type that represents a value that may or may not be present.
   * Similar to Optional in Java but using the ADT concept.
   * Therefore, an Optional is a sum type with two cases: Maybe and Empty.
   * Maybe contains the value, and Empty represents the absence of a value.
   *
   * @tparam A
   */
  enum Optional[+A]:
    case Maybe(value: A)
    case Empty()

  object Optional:
    /**
     * isEmpty returns true if the optional is Empty, false otherwise.
     * Example:
     *
     * isEmpty(Empty()) == true
     * isEmpty(Maybe(1)) == false
     *
     * @param optional the optional to check
     * @tparam A the type of the optional
     * @return true if the optional is Empty, false otherwise
     */
    def isEmpty[A](optional: Optional[A]): Boolean = optional match
      case Empty() => true
      case _ => false

    /**
     *
     * getOrElse returns the value of the optional if it is Maybe, otherwise it returns the default value.
     * Example:
     * orElse(Maybe(1), 0) == 1
     * orElse(Empty(), 0) == 0
     *
     * @param optional the optional to get the value from
     * @param default the default value to return if the optional is Empty
     * @tparam A the type of the optional
     * @tparam B the type of the default value
     * @return the value of the optional if it is Maybe, otherwise the default value
     */
    def orElse[A, B >: A](optional: Optional[A], default: B): B = optional match
      case Maybe(value) => value
      case Empty() => default

    /**
     * map applies the function f to the value of the optional if it is Maybe, otherwise it returns Empty.
     * Example:
     *
     * map(Maybe(1), (x: Int) => x + 1) == Maybe(2)
     * map(Empty(), (x: Int) => x + 1) == Empty()
     *
     *
     * @param optional the optional to apply the function to
     * @param f the function to apply to the value of the optional
     * @tparam A the type of the optional
     * @tparam B the type of the result of the function
     * @return the result of applying the function to the value of the optional if it is Maybe, otherwise Empty
     */
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Maybe(value) => Maybe(f(value))
      case _  => Empty()
    
    def filter[A](optional: Optional[A])(predicate: A => Boolean): Optional[A] = optional match
      case Maybe(value) if predicate(value) => Maybe(value)
      case Maybe(value) if !predicate(value) => Empty()
      case Empty() => Empty()

class OptionalTest:
  @Test def emptyOptionalShouldBeEmpty(): 
    val empty = Optional.Empty()
    assertTrue(Optional.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): 
    val nonEmpty = Optional.Maybe(0)
    assertFalse(Optional.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): 
    val nonEmpty = Optional.Maybe(0)
    assertEquals(0, Optional.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): 
    val empty = Optional.Empty()
    assertEquals(1, Optional.orElse(empty, 1))

  /** Task 5 -- Look the behaviour of map operator */
  @Test def mapShouldReturnEmptyWhenEmpty():
    val empty: Optional[Int] = Optional.Empty()
    val result = Optional.map(empty, _ + 1)
    assertTrue(Optional.isEmpty(result))

  @Test def mapShouldReturnTransformedValueWhenNonEmpty(): 
    val nonEmpty = Optional.Maybe(0)
    val result = Optional.map(nonEmpty, _ + 1)
    assertEquals(1, Optional.orElse(result, 1))

  @Test def filterWithNonEmptyAndTruePredicateShouldKeepTheValue(): 
    val nonEmpty = Optional.Maybe(5)
    assertEquals(Optional.Maybe(5), filter(nonEmpty)(_ > 2))

  @Test def filterWithNonEmptyAndFalsePredicateShouldReturnEmpty(): 
    val nonEmpty = Optional.Maybe(5)
    assertEquals(Optional.Empty(), filter(nonEmpty)(_ > 8))

  @Test def filterWithEmptyShouldReturnEmpty(): 
    val empty = Optional.Empty[Int]()
    assertEquals(Optional.Empty(), filter(empty)(_ > 8))

  @Test def filterWithStrings(): 
    val optionalString = Optional.Maybe("hello")
    assertEquals(Optional.Maybe("hello"), filter(optionalString)(_.length() > 2))