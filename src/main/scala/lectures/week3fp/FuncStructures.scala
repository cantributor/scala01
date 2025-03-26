package lectures.week3fp

import scala.util.Try

val someVal = Some(2)
val result5 = someVal.flatMap(v => Option(v * 2))
val result6 = someVal.map(_ * 2)
//----------------------------------------------------------------------------------------------------------------------
def firstMethod(): Try[String] = Try(throw new RuntimeException("Exception"))

def secondMethod(): Try[Exception] = Try(new RuntimeException("Exception"))
//----------------------------------------------------------------------------------------------------------------------
def double(aList: List[Int]): List[Int] = aList.map(_ * 2)
//----------------------------------------------------------------------------------------------------------------------
def f(aList: List[Int]): Int = Try(aList.product / aList.sum).getOrElse(0)
//----------------------------------------------------------------------------------------------------------------------
def callByName(n: => Int): Int = {
  scala.math.pow(n, 3).toInt
}

def double(n: Int): Int = {
  println(s"double $n")
  2 * n
}
//----------------------------------------------------------------------------------------------------------------------
case class User(id: Int, name: String)

val userOptions: List[Option[User]] = List(None, Some(User(1, "Alice")), Some(User(2, "Bob")))
val users1: List[User] = userOptions.flatten // without None
val users2: List[User] = userOptions.flatMap(userOption => userOption.iterator) // without None
//----------------------------------------------------------------------------------------------------------------------
