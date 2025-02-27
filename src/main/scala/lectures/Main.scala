package lectures

import lectures.week2oop.{Apple, Button, Course1, Course2, Event, GalaApple, GreenApple, Guitar, Instructor, Listener, Order, Person, RegularCustomer, RoundedButton, Store, TestButton}

object Main {

  def main(fArgs: Array[String]): Unit = {
    //    val notification: Listener = new Listener("mousedown", null)
    //    notification
    //      .register((eventName: String) => println(s"trigger -$eventName- event"))
    //      .sendNotification()

    //    val order = new Order(RegularCustomer(true))
    //    println(order.showMenu)

    //    val guitar = Guitar.apply(2024)
    //    println(guitar)


    val store: Store[GalaApple] = new Store[Apple]

    store.sell(new Apple("Apple-4135"))
    store.sell(new GalaApple("GalaApple-4133"))
    store.sell(new GreenApple("GreenApple-3344"))
  }
}
