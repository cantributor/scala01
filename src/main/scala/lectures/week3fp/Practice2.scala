package lectures.week3fp

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
