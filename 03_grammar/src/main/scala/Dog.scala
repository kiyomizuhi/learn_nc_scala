object Dog {

  def apply(name: String) = new Dog(name)

  def apply(id: Int) = new Dog(s"doggy ${id}")

  def printName(dog: Dog): Unit = println(dog.name)
}

class Dog(private val name: String) {

  def greet(): Unit = println(s"${name}!")
}