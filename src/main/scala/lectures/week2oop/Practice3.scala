package lectures.week2oop

trait Event {
  def id: Int

  def operation: String

  def status: String
}

case class UserEvent(id: Int, operation: String, status: String) extends Event

case class SystemEvent(id: Int, operation: String, status: String) extends Event

trait Updatable[T <: Event] {
  def update(event: T, status: String): Event
}

object UpdatableData {
  val userEvent: Updatable[UserEvent] = (event: UserEvent, newStatus: String) => event.copy(status = newStatus)

  val systemEvent: Updatable[SystemEvent] = (event: SystemEvent, newStatus: String) => event.copy(status = newStatus)
}

class Service[T <: Event](event: T, upd: Updatable[T]) {
  def update(status: String): Event = upd.update(event, status)
}