class User(private val name: String, private val age: Int) {
  override def toString = s"User($name, $age)"
}

object User {
  def printAge(user: User): Unit = println(s"age is ${user.age}")
}