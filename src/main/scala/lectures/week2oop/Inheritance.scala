package lectures.week2oop

class Restaurant(name: String = "Unique Cafe") {
  def info(): Unit = println(s"This is $name")
}

class Cafe extends Restaurant

class Button(label: String = "test") {
  def click(): String = s"button -$label- has been clicked"
}

class RoundedButton(label: String = "test") extends Button(label) {
  override def click(): String = s"rounded button -$label- has been clicked"
}

class TestButton extends Button {
  override def click(): String = s"test ${super.click()}"
}
