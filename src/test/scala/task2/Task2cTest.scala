package task2

package task2

import org.junit.*
import org.junit.Assert.*
import Task2c.genericNeg

class Task2cTest:
    @Test 
    def testNegWithStringType(): Unit = {
        val isEmptyString: String => Boolean = _ == ""
        val isNotEmptyString = genericNeg(isEmptyString)
        assertTrue(isNotEmptyString("String"))
        assertFalse(isNotEmptyString(""))
    }

    @Test 
    def testNegWithIntType(): Unit = {
        val isEvenNumber: Int => Boolean = number => number % 2 == 0
        val isNotEvenNumber = genericNeg(isEvenNumber)
        assertTrue(isNotEvenNumber(3))
        assertFalse(isNotEvenNumber(2))
    }

    

