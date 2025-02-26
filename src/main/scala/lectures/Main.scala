package lectures

import lectures.week2oop.{Button, Course1, Course2, Event, Instructor, Listener, Person, RoundedButton, TestButton}

object Main {

  def main(fArgs: Array[String]): Unit = {
    val notification: Listener = new Listener("mousedown", null)
    notification
      .register((eventName: String) => println(s"trigger -$eventName- event"))
      .sendNotification()
  }
}
