package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*
import task5.Optionals.Optional.filter

class OptionalTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit = {
    val empty = Optional.Empty()
    assertTrue(Optional.isEmpty(empty))
  }

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit = {
    val nonEmpty = Optional.Maybe(0)
    assertFalse(Optional.isEmpty(nonEmpty))
  }

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit = {
    val nonEmpty = Optional.Maybe(0)
    assertEquals(0, Optional.orElse(nonEmpty, 1))
  }

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit = {
    val empty = Optional.Empty()
    assertEquals(1, Optional.orElse(empty, 1))
  }

  /** Task 5 -- Look the behaviour of map operator */
  @Test def mapShouldReturnEmptyWhenEmpty(): Unit = {
    val empty: Optional[Int] = Optional.Empty()
    val result = Optional.map(empty, _ + 1)
    assertTrue(Optional.isEmpty(result))
  }

  @Test def mapShouldReturnTransformedValueWhenNonEmpty(): Unit = {
    val nonEmpty = Optional.Maybe(0)
    val result = Optional.map(nonEmpty, _ + 1)
    assertEquals(1, Optional.orElse(result, 1))
  }

  @Test def filterWithNonEmptyAndTruePredicateShouldKeepTheValue(): Unit = {
    val nonEmpty = Optional.Maybe(5)
    assertEquals(Optional.Maybe(5), filter(nonEmpty)(_ > 2))
  }

  @Test def filterWithNonEmptyAndFalsePredicateShouldReturnEmpty(): Unit = {
    val nonEmpty = Optional.Maybe(5)
    assertEquals(Optional.Empty(), filter(nonEmpty)(_ > 8))
  }

  @Test def filterWithEmptyShouldReturnEmpty(): Unit = {
    val empty = Optional.Empty[Int]()
    assertEquals(Optional.Empty(), filter(empty)(_ > 8))
  }

  @Test def filterWithStrings(): Unit = {
    val optionalString = Optional.Maybe("hello")
    assertEquals(Optional.Maybe("hello"), filter(optionalString)(_.length() > 2))
  }

  

  