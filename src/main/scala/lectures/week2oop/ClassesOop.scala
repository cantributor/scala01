package lectures.week2oop

class Employee1(val name: String, var salary: Double) {
  def this() = this("John", 0)
}

def printEmployee(): Unit = {
  val employee = new Employee1()
  println(s"${employee.name}'s salary is ${employee.salary}")
}

class Instructor(val instructorId: Int, name: String, surname: String) {
  def fullName(): String = s"${name.capitalize} ${surname.capitalize}"
}

class Course1(courseId: Int, title: String, val releaseYear: String, instructor: Instructor) {
  def getId(): String = s"$courseId${instructor.instructorId}"

  def isTaughtBy(instructor: Instructor): Boolean =
    instructor.instructorId == this.instructor.instructorId &&
      instructor.fullName() == this.instructor.fullName()

  def copyCourse(newReleaseYear: String): Course1 = new Course1(this.courseId, this.title, newReleaseYear, this.instructor)
}
