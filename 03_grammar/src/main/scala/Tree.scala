sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree

object BinaryTree {
  def max(tree: Tree): Int = {
    tree match {
      case Branch(v, Empty, Empty) => v
      case Branch(v, left, Empty) =>
        val x = max(left)
        if (v > x) v else x
      case Branch(v, Empty, right) =>
        val x = max(right)
        if (v > x) v else x
      case Branch(v, left, right) =>
        val x = max(left)
        val y = max(right)
        if (v > x) {
          if (v > y) v else y
        } else {
          if (x > y) x else y
        }
      case Empty =>
        throw new RuntimeException
    }
  }

  def min(tree: Tree): Int = {
    tree match {
      case Branch(v, Empty, Empty) => v
      case Branch(v, left, Empty) =>
        val x = min(left)
        if (v < x) v else x
      case Branch(v, Empty, right) =>
        val x = min(right)
        if (v < x) v else x
      case Branch(v, left, right) =>
        val x = min(left)
        val y = min(right)
        if (v < x) {
          if (v < y) v else y
        } else {
          if (x < y) x else y
        }
      case Empty =>
        throw new RuntimeException
    }
  }

  def depth(tree: Tree): Int = {
    tree match {
      case Empty => 0
      case Branch(_, left, right) =>
        val ld = depth(left)
        val rd = depth(right)
        if (ld > rd) ld + 1 else rd + 1
    }
  }
}
