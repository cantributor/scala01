package lectures.week3fp

//----------------------------------------------------------------------------------------------------------------------
val strlen = (s: String) => s.length
//----------------------------------------------------------------------------------------------------------------------
def createUrl(baseUrl: String): String => String = (path: String) => s"https://$baseUrl/$path"

val stepikUrl = createUrl("stepik.org")
val stepikLogin = stepikUrl("login")
//----------------------------------------------------------------------------------------------------------------------
val progLanguages = List("java", "scala", "python")
val lngAbbrev = List("JA", "SCA", "PY")
val result4 = progLanguages.flatMap(l => lngAbbrev.map(a => (a, l))).filter((a, l) => l.toUpperCase.startsWith(a))
//----------------------------------------------------------------------------------------------------------------------
val aList1 = List(1, 2, 3)
val aList2 = List(4, 6, 7)
val aList3 = List(10, 100, 1000)

val result2: List[Int] = aList1.flatMap(l1 => aList3.map(l3 => l3 * (l1 + aList2.max)))
//----------------------------------------------------------------------------------------------------------------------
val input1 = "9-876-543-21-09"
def countNumbers(s: String): Map[Char, Int] = s.filter(_ != '-').groupBy(identity).map(t => (t._1, t._2.length))
val result3 = countNumbers(input1)

//----------------------------------------------------------------------------------------------------------------------
trait WeekDay

object Mon extends WeekDay

object Tue extends WeekDay

object Wed extends WeekDay

object Thu extends WeekDay

object Fri extends WeekDay

object Sat extends WeekDay

object Sun extends WeekDay

object Unk extends WeekDay

def dayOfWeek(dayNumber: Int): WeekDay = dayNumber match {
  case 1 => Mon
  case 2 => Tue
  case 3 => Wed
  case 4 => Thu
  case 5 => Fri
  case 6 => Sat
  case 7 => Sun
  case _ => Unk
}
//----------------------------------------------------------------------------------------------------------------------
def getType(collection: Any): String = {
  collection match {
    case i: Iterable[_] => if (i.nonEmpty) i.iterator.next() match {
      case _: String => "Collection Of Strings"
      case _: Int => "Collection Of Ints"
      case _: Double => s"Collection Of Doubles"
      case _ => "Unknown type"
    } else "Unknown type"
    case _: Array[Int] => "Collection Of Ints"
    case _: Array[Double] => "Collection Of Doubles"
    case _: Array[String] => "Collection Of Strings"
    case _ => "Unknown type"
  }
}
//----------------------------------------------------------------------------------------------------------------------
case class Course1(id: Int, title: String, studentCount: Int)

val courses = List(
  Course1(0, "Scala", 10),
  Course1(3, "Advanced Scala", 20),
  Course1(2, "Spark", 4),
  Course1(1, "Cats", 10)
)

implicit val courseOrdering: Ordering[Course1] = Ordering.by(course => (course.studentCount, course.id))
//----------------------------------------------------------------------------------------------------------------------
