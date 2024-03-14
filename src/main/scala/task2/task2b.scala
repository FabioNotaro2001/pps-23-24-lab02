package task2

object Task2b extends App:
    def neg (predicate : String => Boolean) : String => Boolean = 
        givenString => !predicate(givenString)
     
