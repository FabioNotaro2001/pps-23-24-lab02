package task2

object Task2a extends App:
    // Punto a.
    // Val assigned to function literal (lambda).
    val positive : Int => String = _ match
        case p if p >= 0 => "positive"
        case _ => "negative"

    // Method syntax.
    def positiveMethod(number: Int) : String = number match
        case p if p >= 0 => "positive"
        case _ => "negative"
    


    

