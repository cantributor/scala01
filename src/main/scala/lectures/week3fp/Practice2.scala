package lectures.week3fp

import scala.annotation.tailrec

//----------------------------------------------------------------------------------------------------------------------
val input: String = " John Smith "
//val input: String = null

case class Person(name: String)

object Person {
  def unapply(name: String): Option[String] = {
    if (name == null || name.trim.isEmpty)
      Some("Failed to get initials")
    else
      Some(name
        .split(" ")
        .toList
        .map(s => if (s.isEmpty) "" else s.substring(0, 1).toUpperCase + ".")
        .mkString(" "))
  }
}

val Person(initials) = input
//----------------------------------------------------------------------------------------------------------------------
def compare(v1: String, v2: String): Int = {

  def toList(s: String): List[Int] = s.split("\\.").map(_.toInt).toList

  val src1 = toList(v1)
  val src2 = toList(v2)
  val maxSize = math.max(src1.length, src2.length)

  def withZeros(list: List[Int]): List[Int] = list ::: List.fill(maxSize - list.size) {
    0
  }

  val list1 = withZeros(src1)
  val list2 = withZeros(src2)
  val list1WithIndex = list1.zipWithIndex

  val unequal = list1WithIndex.find({ case (elem, index) => elem != list2(index) })
  unequal.map({ case (elem, index) => if (elem > list2(index)) 1 else -1 }).getOrElse(0)
}
//----------------------------------------------------------------------------------------------------------------------
def duplicate[T](list: List[T], num: Int): List[T] = list.flatMap(element => List.fill(num)(element))
//----------------------------------------------------------------------------------------------------------------------
def countChars(s: String): Map[Char, Int] = s.map(_.toLower).groupBy(identity).mapValues(_.length).toMap
//----------------------------------------------------------------------------------------------------------------------
def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] =
  network + (location -> Set())

def connect(network: Map[String, Set[String]], locationA: String, locationB: String): Map[String, Set[String]] = {
  val network2 = network + (locationA -> (network(locationA) + locationB))
  network2 + (locationB -> (network(locationB) + locationA))
}

def disconnect(network: Map[String, Set[String]], locationA: String, locationB: String): Map[String, Set[String]] = {
  val network2 = network + (locationA -> (network(locationA) - locationB))
  network2 + (locationB -> (network(locationA) - locationB))
}

def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
  val network2 = network.map({
    case (loc, connections) =>
      loc -> connections.-(location)
  })
  network2.-(location)
}

def flightCount(network: Map[String, Set[String]], location: String): Int = network(location).size

def mostFlights(network: Map[String, Set[String]]): String =
  network.maxBy({
    case (loc, connections) =>
      connections.size
  })._1

def numLocationsWithNoFlights(network: Map[String, Set[String]]): Int =
  network.count({ case (location, connections) => connections.isEmpty })

def isConnected(network: Map[String, Set[String]], locationA: String, locationB: String): Boolean = {
  @tailrec
  def loop(accumulator: Set[String]): Set[String] = {
    val connectionsToAdd = network
      .filter({ case (location, connections) => accumulator.contains(location) })
      .flatMap({ case (location, connections) => connections })
      .toSet
    val resultConnections = accumulator.union(connectionsToAdd)
    val reallyAdded = resultConnections.size - accumulator.size
    if (reallyAdded == 0)
      resultConnections
    else
      loop(resultConnections)
  }

  loop(network(locationA)).contains(locationB)
}

//----------------------------------------------------------------------------------------------------------------------
val course = "Scala"
val doLogin = true
val doEnroll = true

object LoginService {
  def login(): Platform = if (doLogin) new Platform else throw new RuntimeException("Failed to login")
}

class Platform {
  def enroll(): String = if (doEnroll) course else throw new RuntimeException("You can not enrol yourself in this course")
}

object NotificationService {
  def notify(course: String): Unit = println("Notify")
}