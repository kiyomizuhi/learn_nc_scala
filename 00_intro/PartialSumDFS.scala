object PartialSumDFS extends App {
    val a = Seq(3, 6, -5, 7)
    val n = a.length
    val k = 8

    def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {
        if (index == n) {
            return if (partial.sum == k) (true, partial) else (false, Seq())
        }
        val (isMatchNotAdd, resultNotAdd) = isMatchAndResult(index + 1, partial)
        if (isMatchNotAdd) return (true, resultNotAdd)

        isMatchAndResult(index + 1, partial :+ a(index))
    }

    val (isMatch, result) = isMatchAndResult(0, Seq())

    if (isMatch) println(s"yes: ${result}") else println("no")
}