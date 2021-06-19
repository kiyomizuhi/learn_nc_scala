object SimpleSearch extends App {
    val text = "bvaindabcvjiasuianvaomravranvfavabcniwu".toSeq
    val pattern = "abc".toSeq
    val matchIndexes = search(text, pattern)

    def search(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {
        var matchIndexes = Seq[Int]()
        for (i <- 0 to text.length - 1) {
            val textSliced = text.slice(i, i + pattern.length)
            if (isMatch(textSliced, pattern)) {
                matchIndexes = matchIndexes :+ i
            }
        }
        matchIndexes
    }

    def isMatch(text: Seq[Char], pattern: Seq[Char]): Boolean = {
        var isMatched = true
        if (text.length == pattern.length) {
            for (i <- 0 to text.length - 1) {
                if (text(i) != pattern(i)) {
                    isMatched = false
                }
            }
        } else {
            isMatched = false
        }
        isMatched
    }

    println(s"found at ${matchIndexes}")
}