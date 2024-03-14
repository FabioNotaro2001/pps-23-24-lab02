package task2

object Task2e extends App:
    def compose(f: Int => Int, g: Int => Int): Int => Int = number => f(g(number))

    // Note the constraint about type relationships between f and g.
    def genericCompose[X, Y, Z](f: Y => Z, g: X => Y): X => Z =
      x => f(g(x))