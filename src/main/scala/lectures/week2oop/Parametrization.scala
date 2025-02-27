package lectures.week2oop

abstract class Customer {
  def isVegetarian: Boolean
}

case class RegularCustomer(isVegetarian: Boolean) extends Customer

case class NewCustomer(isVegetarian: Boolean) extends Customer

class Order[T <: Customer](val person: T) {
  def showMenu: String = if (person.isVegetarian) "vegetarian menu" else "ordinary menu"
}

//----------------------------------------------------------------------------------------------------------------------
abstract class MusicInstrument[A] {
  val productionYear: Int
}

object MusicInstrument {
  def apply[T](py: Int): MusicInstrument[T] = new MusicInstrument[T] {
    override val productionYear: Int = py
  }
}

case class Guitar(productionYear: Int) extends MusicInstrument

case class Piano(productionYear: Int) extends MusicInstrument

//----------------------------------------------------------------------------------------------------------------------
trait Fruit {
  val code: String

  override def toString: String = s"$code"
}

class Apple(val code: String) extends Fruit

class GalaApple(code: String) extends Apple(code)

class GreenApple(code: String) extends Apple(code)

class Store[-T] {
  def sell[T >: Apple](fruit: T): Unit = println(s"sell $fruit")
}
