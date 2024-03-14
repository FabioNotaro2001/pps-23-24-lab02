package task2

object Task2c extends App:
    def genericNeg[X] (predicate : X => Boolean) : X => Boolean = 
        givenElement => !predicate(givenElement)
