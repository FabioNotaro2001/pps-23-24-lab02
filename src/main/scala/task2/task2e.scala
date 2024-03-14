package task2

object Task2e extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = number => f(g(number))

    def genericCompose[A](f: A => A, g: A => A): A => A = number => f(g(number))    // Constraint: one single type admitted.


