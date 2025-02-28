package lectures.week2oop

class Person1(name: String)

object Person1 {
  val age = 30
}

val bob = Person1("Bob")

case class Course2(title: String, instructor: String)

object Course2 {
  def apply(instructor: String): Course2 = Course2("AdvancedScala", instructor)
}