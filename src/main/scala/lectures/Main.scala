package lectures

import lectures.week3fp.{compare}


object Main {

  def main(fArgs: Array[String]): Unit = {
    println(compare("1.0.2.03", "1.1.0") == -1)
    println(compare("2.1", "2.01") == 0)
    println(compare("3.0", "3.0.0.0") == 0)
    println(compare("4", "4.0.0.1") == -1)
    println(compare("4.0.1", "4.0.0.1") == 1)
    println(compare("1.10.1", "11.0.1") == -1)

    //------------------------------------------------------------------------------------------------------------------
    //    println(s"$initials")
    //------------------------------------------------------------------------------------------------------------------
    //    println(powerOfTwo)
    //------------------------------------------------------------------------------------------------------------------
    //    println(Company(title, employeeCount) - retiredCount)
    //------------------------------------------------------------------------------------------------------------------
    //    display(loadFromDb())
    //------------------------------------------------------------------------------------------------------------------
    //    println(callByName(double(1)))
    //------------------------------------------------------------------------------------------------------------------
    //    println(f(List(4, 7)))
    //------------------------------------------------------------------------------------------------------------------
    //    println(firstMethod().orElse(secondMethod()))
    //------------------------------------------------------------------------------------------------------------------
    //    val age: String = "34"
    //
    //    case class Employee(age: Int) {
    //      def displayAge(): Unit = println(s"Employee's age is $age")
    //    }
    //
    //    object Employee {
    //      implicit def createEmployee(age: String): Employee = Employee(age.toInt)
    //    }
    //
    //    object Helper {
    //      implicit def createInt(implicit value: String): Int = value.toInt
    //    }
    //
    //    import Employee.createEmployee
    //
    //    age.displayAge()
    //------------------------------------------------------------------------------------------------------------------
    //    println(courses.sorted)
    //------------------------------------------------------------------------------------------------------------------
    //    println(getType(List(1, 3)))
    //    println(getType(Array(1.1, 3.2)))
    //------------------------------------------------------------------------------------------------------------------
    //    val event = UserEvent(1, "account_create", "in_process")
    //    val service = new Service(event, UpdatableData.userEvent)
    //
    //    val eventUpdated = service.update("complete")
    //
    //    println(eventUpdated) // UserEvent(1,account_create,complete)
    //------------------------------------------------------------------------------------------------------------------
    //    val baseAccount = BaseAccount(
    //      accountId = 1,
    //      accountType = PaidAccount,
    //      settings = Settings.AccountSettings(
    //        email = "test@mail.com",
    //        password = "abr#45&",
    //        picture = "link/to/some/pic"))
    //
    //    baseAccount.info()
    //    baseAccount.performAction()
    //    println(baseAccount)
    //------------------------------------------------------------------------------------------------------------------
    //    val branch = Branch()
    //    val account = branch.openAccount("personal")
    //
    //    println(account)
    //------------ abstraction -----------------------------------------------------------------------------------------
    //    val notification: Listener = new Listener("mousedown", null)
    //    notification
    //      .register((eventName: String) => println(s"trigger -$eventName- event"))
    //      .sendNotification()
    //------------- parametrization ------------------------------------------------------------------------------------
    //    val order = new Order(RegularCustomer(true))
    //    println(order.showMenu)
    //------------------------------------------------------------------------------------------------------------------
    //    val guitar = Guitar.apply(2024)
    //    println(guitar)
    //
    //    MusicalInstrument.play(Violin) // playing Violin
    //    MusicalInstrument.play(Drum) // playing Drum
    // -----------------------------------------------------------------------------------------------------------------
    //    val store: Store[GalaApple] = new Store[Apple]
    //
    //    store.sell(new Apple("Apple-4135"))
    //    store.sell(new GalaApple("GalaApple-4133"))
    //    store.sell(new GreenApple("GreenApple-3344"))
    //-------- syntactic shugar ----------------------------------------------------------------------------------------
    //    println(!EnglishStudent(true)) // This person is not fluent in English
    //    println(!EnglishStudent(false)) // This person is fluent in English
    //------------------------------------------------------------------------------------------------------------------
    //    println(new Client("Bob").madeOrder)
    //------------------------------------------------------------------------------------------------------------------
    //    val bob = new Person("Bob")
    //    println((+bob).name) // Bob NoSurname
    //
    //    val alice = new Person("Alice")
    //    println((+alice).name) // Alice NoSurname
  }
}
