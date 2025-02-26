package lectures.week2oop

abstract class Event {
  def trigger(eventName: String): Unit
}

class Listener(eventName: String, event: Event) {
  def register(newEvent: Event): Listener = {
    new Listener(eventName, newEvent)
  }

  def sendNotification(): Unit = {
    event.trigger(eventName)
  }
}