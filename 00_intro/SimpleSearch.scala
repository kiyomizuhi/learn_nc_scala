object SimpleSearch extends App {
    val text = "bvaindabcvjiasuianvaomravranvfavabcniwu".toSeq
    val pattern = "abc".toSeq
    val matchIndexes = search(text, pattern)

    def search(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {
        var matchIndexes = Seq[Int]()
        for (i <- 0 to text.length - 1) {
            val textSliced = text.slice(i, i + pattern.length)
            println(textSliced)
        }
        matchIndexes
    }

    println(s"found at ${matchIndexes}")
}