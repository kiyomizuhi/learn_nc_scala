case class Edge(from: Char, to: Char, distance: Int)

object ShortestPath {
  val vertexes = 'A' to 'G'

  val edges = Seq(
    Edge('A', 'B', 1),
    Edge('A', 'C', 8),
    Edge('B', 'A', 1),
    Edge('B', 'C', 6),
    Edge('B', 'D', 6),
    Edge('B', 'E', 6),
    Edge('C', 'A', 8),
    Edge('C', 'B', 6),
    Edge('C', 'D', 7),
    Edge('D', 'B', 6),
    Edge('D', 'C', 7),
    Edge('D', 'F', 2),
    Edge('E', 'B', 6),
    Edge('E', 'F', 6),
    Edge('E', 'G', 8),
    Edge('F', 'D', 2),
    Edge('F', 'E', 6),
    Edge('F', 'G', 5),
    Edge('G', 'E', 8),
    Edge('G', 'F', 5)
  )

  def solveWithBellmanFord(start: Char, goal: Char): Unit = {
    var distances = vertexes.map(v => (v -> Int.MaxValue)).toMap
    distances = distances + (start -> 0)

    var isUpdated = true
    while (isUpdated) {
      isUpdated = false
      edges.foreach(e =>
        if ((distances(e.from) < Int.MaxValue)
          && (distances(e.to) > distances(e.from) + e.distance)) {
          distances = distances + (e.to -> (distances(e.from) + e.distance))
          isUpdated = true
        }
      )
    }
    println(distances)
    println(distances(goal))
  }
}
