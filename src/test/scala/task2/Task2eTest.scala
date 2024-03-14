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
        assertEquals(9, genericCompose[Int](_-1, _*2)(5))
        assertEquals(2, genericCompose[Int](_+1, _-1)(2))
    }

    @Test 
    def testGenericComposeWithString(): Unit = {
        def concatenate(initialPart: String, finalPart: String): String = initialPart + finalPart

        assertEquals("PrimaPoiInfine", genericCompose[String](concatenate(_, "Infine"), concatenate(_, "Poi"))("Prima"))
    }

    


