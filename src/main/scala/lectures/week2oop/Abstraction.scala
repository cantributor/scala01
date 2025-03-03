package lectures.week2oop

abstract class Event2 {
  def trigger(eventName: String): Unit
}

class Listener(eventName: String, event: Event2) {
  def register(newEvent: Event2): Listener = {
    new Listener(eventName, newEvent)
  }

  def sendNotification(): Unit = {
    event.trigger(eventName)
  }
}