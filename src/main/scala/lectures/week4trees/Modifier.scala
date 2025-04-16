package lectures.week4trees

class Modifier[A](var someVar: A) {
  def modifier: A = someVar

  def modifier_=(value: A): Unit = someVar = value
}
