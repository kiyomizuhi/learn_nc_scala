object RegexSearch extends App {
    val text = "bvaindabcvjiasuianvaomravranvfavabcniwu"
    val pattern = "abc"
    val matchIndexes = pattern.r.findAllIn(text).matchData.map(_.start).toList

    println(s"found at ${matchIndexes}")
}