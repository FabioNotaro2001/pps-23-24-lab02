package task2

import org.junit.*
import org.junit.Assert.*
import Task2d.p1
import Task2d.p2
import Task2d.p3
import Task2d.p4

class Task2dTest:
    @Test 
    def testp1(): Unit = {
        assertTrue(p1(3)(10)(10))
        assertFalse(p1(3)(11)(10))
        assertFalse(p1(12)(5)(5))
    }

    @Test 
    def testp2(): Unit = {
        assertTrue(p2(3, 10, 10))
        assertFalse(p2(3, 11, 10))
        assertFalse(p2(12, 5, 5))
    }

    @Test 
    def testp3(): Unit = {
        assertTrue(p3(3)(10)(10))
        assertFalse(p3(3)(11)(10))
        assertFalse(p3(12)(5)(5))
    }

    @Test 
    def testp4(): Unit = {
        assertTrue(p4(3, 10, 10))
        assertFalse(p4(3, 11, 10))
        assertFalse(p4(12, 5, 5))
    }
