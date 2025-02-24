package lectures.week2oop

class Person(name: String)

object Person {
  val age = 30
}

val bob = Person("Bob")

case class Course2(title: String, instructor: String)

object Course2 {
  def apply(instructor: String): Course2 = Course2("AdvancedScala", instructor)
}