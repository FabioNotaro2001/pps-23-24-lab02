import org.junit.*
import org.junit.Assert.*
import task2.Task2.positive
import task2.Task2.positiveMethod

class Task2Test:
    @Test 
    def testpositiveValWithActualPositive(): Unit = {
        assertEquals("positive", positive(10))
    }

    @Test 
    def testPositiveValWithActualNegative(): Unit = {
        assertEquals("negative", positive(-10))
    }

    @Test 
    def testPositiveValWithInconsistence(): Unit = {
        assertNotEquals("positive", positive(-10))
    }

    @Test 
    def testpositiveDefWithActualPositive(): Unit = {
        assertEquals("positive", positiveMethod(10))
    }

    @Test 
    def testPositiveDefWithActualNegative(): Unit = {
        assertEquals("negative", positiveMethod(-10))
    }

    @Test 
    def testPositiveDefWithInconsistence(): Unit = {
        assertNotEquals("positive", positiveMethod(-10))
    }
