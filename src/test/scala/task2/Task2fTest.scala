package task2

import org.junit.*
import org.junit.Assert.*
import Task2f.gcd

class Task2fTest:
    @Test 
    def testGCDWithEasyCase(): Unit = {
        assertEquals(10, gcd(100, 30))
    }

    @Test 
    def testGCDWithSwitchedNumbers(): Unit = {
        assertEquals(5, gcd(5, 10))
    }

    @Test 
    def testGCDWithPrimeNumbers(): Unit = {
        assertEquals(1, gcd(7, 3))
    }
