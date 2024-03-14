package task2

import org.junit.*
import org.junit.Assert.*
import Task2b.neg

class Task2bTest:
    @Test 
    def testNegWithNonEmptyString(): Unit = {
        val isEmptyString: String => Boolean = _ == ""
        val isNotEmptyString = neg(isEmptyString)
        assertTrue(isNotEmptyString("String"))
        assertFalse(isNotEmptyString(""))
    }

    @Test 
    def testNegWithShortString(): Unit = {
        val isShortString: String => Boolean = givenString => givenString.length() <= 4
        val isNotShortString = neg(isShortString)
        assertTrue(isNotShortString("Very-long string"))
        assertFalse(isNotShortString("ab"))
    }
