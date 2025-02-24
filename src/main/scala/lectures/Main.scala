package lectures

import lectures.week2oop.{Course1, Course2, Instructor, Person}

object Main {

  def main(fArgs: Array[String]): Unit = {
    println(Person.age)
    val scalaCourse = Course2("Scala", "Bob")

    val course21 = Course2("Scala", "Bob")

    val course22 = scalaCourse.copy()

    val course23 = new Course2("Scala", "Bob")

    val course24 = Course2("Alice")

//    val course25 = new Course2("Scala")

    val course26 = scalaCourse.copy("AdvancedScala")

    println(course26)
  }
}
