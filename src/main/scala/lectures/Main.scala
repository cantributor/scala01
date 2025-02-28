package lectures

import lectures.week2oop.{Drum, MusicalInstrument, Violin}

object Main {

  def main(fArgs: Array[String]): Unit = {
    //    val notification: Listener = new Listener("mousedown", null)
    //    notification
    //      .register((eventName: String) => println(s"trigger -$eventName- event"))
    //      .sendNotification()
    //------------------------------------------------------------------------------------------------------------------
    //    val order = new Order(RegularCustomer(true))
    //    println(order.showMenu)
    //------------------------------------------------------------------------------------------------------------------
    //    val guitar = Guitar.apply(2024)
    //    println(guitar)
    MusicalInstrument.play(Violin) // playing Violin
    MusicalInstrument.play(Drum) // playing Drum
    // -----------------------------------------------------------------------------------------------------------------
    //    val store: Store[GalaApple] = new Store[Apple]
    //
    //    store.sell(new Apple("Apple-4135"))
    //    store.sell(new GalaApple("GalaApple-4133"))
    //    store.sell(new GreenApple("GreenApple-3344"))
    //------------------------------------------------------------------------------------------------------------------
    //    println(!EnglishStudent(true)) // This person is not fluent in English
    //    println(!EnglishStudent(false)) // This person is fluent in English
    //------------------------------------------------------------------------------------------------------------------
    //    println(new Client("Bob").madeOrder)
  }
}
