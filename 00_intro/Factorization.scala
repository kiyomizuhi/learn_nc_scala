import scala.math.sqrt

object Factorization extends App {
    val target: Int = 24
    val maxDivisor = sqrt(target).toInt

    println(maxDivisor)
}