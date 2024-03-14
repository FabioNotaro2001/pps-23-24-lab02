package task2

import org.junit.*
import org.junit.Assert.*
import Task2e.compose
import Task2e.genericCompose

class Task2eTest:
    @Test 
    def testComposeWithInt(): Unit = {
        assertEquals(9, compose(_-1, _*2)(5))
        assertEquals(2, compose(_+1, _-1)(2))
        assertEquals(80, compose(_*2, _-10)(50))
    }

    @Test 
    def testGenericComposeWithInt(): Unit = {
        def double: Int => Int = number => number * 2
        def increment: Int => Int = number => number + 1
        assertEquals(12, genericCompose(double(_), increment(_))(5))
    }

    @Test 
    def testGenericComposeWithString(): Unit = {
        def concatenate(initialPart: String, finalPart: String): String = initialPart + finalPart
        assertEquals("PrimaPoiInfine", genericCompose(concatenate(_, "Infine"), concatenate(_, "Poi"))("Prima"))
    }

    @Test 
    def testGenericComposeWithIntAndString(): Unit = {
        def convertNumberToString: Integer => String = number => "Number: " + number
        def checkEvenNumberOfChar: String => Boolean = givenString => givenString.length() % 2 == 0

        assertTrue(genericCompose(checkEvenNumberOfChar(_), convertNumberToString(_))(10))
        assertFalse(genericCompose(checkEvenNumberOfChar(_), convertNumberToString(_))(1))
    }