class User(private val name: String, private val age: Int) {
  override def toString = s"User($name, $age)"

  def printAge(user: User): Unit = println(user.age)
}

object User {
  def printAge(user: User): Unit = println(s"age is ${user.age}")

  def apply(name_age: String): User = {
    val res = name_age.split(",")
    val name = res(0)
    val age = res(1).toInt
    new User(name, age)
  }
}