package lectures.week3fp

import lectures.week3fp.SeniorityLevel.{Junior, Middle, Senior}

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
//----------------------------------------------------------------------------------------------------------------------
val title: String = "Company-A"
val employeeCount: Int = 100
val retiredCount: Int = 10

case class Company(title: String, employeeCount: Int)

object Company {
  implicit class Manager(company: Company) {
    def -(peopleCount: Int): Company = Company(company.title, company.employeeCount - peopleCount)
  }
}

//----------------------------------------------------------------------------------------------------------------------
trait SeniorityLevel

object SeniorityLevel {
  case object Junior extends SeniorityLevel

  case object Middle extends SeniorityLevel

  case object Senior extends SeniorityLevel
}

case class Developer(
                      name: String,
                      level: SeniorityLevel,
                      progLanguage: List[String]
                    )

val developers: List[Developer] = List(
  Developer("Alice", Junior, List(String("c++"), "SQL", "c")),
  Developer("Bob", Middle, List("java", "scala", "SQL")),
  Developer("Cris", Senior, List("java")))

val foundDevs: List[String] = developers
  .filter(dev => Set(Middle, Senior).contains(dev.level))
  .filter(dev => dev.progLanguage.size >= 3)
  .map(_.name)
//----------------------------------------------------------------------------------------------------------------------
import scala. math. BigDecimal. int2bigDecimal
val capacity = 1000000000
val power = 34
val powerOfTwo = LazyList.fill(capacity)(2.toBigInt).#::(1.toBigInt).take(power + 1).toList.foldLeft(1.toBigInt)(_ * _)