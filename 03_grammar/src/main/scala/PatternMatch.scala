object PatternMatch {
  def intToName(num: Int): String = {
    num match {
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }
  }

  def message1(message: String): String = {
    message match {
      case "good" => "game"
      case "bad" => "game"
    }
  }

  def message2(message: String): String = {
    message match {
      case "good" | "bad" => "game"
    }
  }

  def matchA1(): Unit = {
    val seq = Seq("A", "B", "C", "D", "E")
    seq match {
      case Seq("A", b, c, d, e) =>
        println("b = " + b)
        println("c = " + c)
        println("d = " + d)
        println("e = " + e)
      case _ =>
        println("nothing")
    }
  }

  def matchA2(): Unit = {
    val seq = Seq("A", "B", "C", "D", "E")
    seq match {
      case Seq("A", b, c, d, e) if b != "B" =>
        println("b = " + b)
        println("c = " + c)
        println("d = " + d)
        println("e = " + e)
      case _ =>
        println("nothing")
    }
  }

  def matchA3(): Unit = {
    val seq = Seq(Seq("A"), Seq("B", "C", "D", "E"))
    seq match {
      case Seq(a@Seq("A"), x) =>
        println(a)
        println(x)
      case _ =>
        println("nothing")
    }
  }

  def matchType1(): Unit = {
    val obj: AnyRef = "String Literal"
    obj match {
      case v: java.lang.Integer => println("Integer!")
      case v: String => println(s"String! length is ${v.length}")
    }
  }

  def matchType2(): Unit = {
    val obj: AnyRef = Seq("a", "b", "c")
    obj match {
      case v: Seq[Int] => println("Seq[Int]")
      case v: Seq[String] => println("Seq[String]")
    }
  }

  def matchType3(): Unit = {
    val obj: AnyRef = Seq("a", "b", "c")
    obj match {
      case v: Seq[_] => println("Seq[_]")
      case _ => println("nothing")
    }
  }

  def printRandomChars(): Unit = {
    for (i <- 1 to 1000) {
      val chars: Seq[Char] = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList
      val result = chars match {
        case Seq(a, b, c, d, _) => Seq(a, b, c, d, a)
        case _ => "other"
      }
      println(result)
    }
  }

  def last(seq: Seq[Int]): Int = {
    seq match {
      case Seq(x) => return x
      case x::xs => last(xs)
    }
  }

  def reverse(seq: Seq[Int]): Seq[Int] = {
    seq match {
      case Seq(x) => return Seq(x)
      case x::xs => reverse(xs) :+ x
     }
  }
}
