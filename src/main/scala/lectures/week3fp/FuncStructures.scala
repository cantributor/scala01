package lectures.week3fp

import com.sun.net.httpserver.Authenticator.Success

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