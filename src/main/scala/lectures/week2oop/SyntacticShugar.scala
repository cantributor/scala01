package lectures.week2oop

import scala.annotation.targetName
import scala.language.postfixOps

case class EnglishStudent(fluentInEnglish: Boolean) {
  @targetName("abc")
  def unary_! : String = {
    if (fluentInEnglish) "This person is not fluent in English"
    else "This person is fluent in English"
  }
}

class Client(name: String) {
  def orders(dishName: String): String = s"$name decided to eat $dishName tonight"

  def madeOrder: String = this orders "Pizza"
}

class Person(val name: String) {
  @targetName("+")
  def unary_+ : Person = new Person(s"$name NoSurname")
}