package lectures.week3fp

//----------------------------------------------------------------------------------------------------------------------
case class Course(id: Int, title: String)

case class Error(id: Int, message: String)

val scalaCourse = Left(Course(1, "Scala"))

def getEnrolledCourses(): List[Either[Error, Course]] = List(
  Right(Course(1, "Java")),
  Left(Error(404, "Not Found")),
  Right(Course(2, "Scala For Beginners")),
  Right(Course(3, "Learn Scala"))
)

val scalaCourses = getEnrolledCourses()
  .flatMap(either => either.toOption)
  .filter(course => course.title.contains("Scala"))

//----------------------------------------------------------------------------------------------------------------------
case class Employee(title: String, position: String)

def loadFromDb(): List[Employee] = {
  println("Loading From DB...")
  List(Employee("Alice", "Account"), Employee("Bob", "Marketing"))
}

def display(employee: List[Employee]): Unit = {
  println(s"First Print: $employee")
  println(s"Second Print: $employee")
}