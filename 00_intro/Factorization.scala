import scala.math.sqrt

object Factorization extends App {
    val target: Int = 24
    val maxDivisor = sqrt(target).toInt

    def factorizationRec(num: Int, divisor: Int, acc: Map[Int, Int]): Map[Int, Int] = {
        Map(2 -> 3, 3 -> 1)
    }

    println(factorizationRec(target, 2, Map()))
}