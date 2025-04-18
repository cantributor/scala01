package lectures

import lectures.week4trees.{tree1, tree2, tree3, exTree, hasPath, TreeEnd, findAllPaths, Modifier}


object Main {

  def main(fArgs: Array[String]): Unit = {
    println(tree1.collectLeaves.map(_.value).sorted)
    println(tree1.countLeaves)
    println(tree1.nodesAtLevel(3).map(_.value).sorted)
    println(tree1.collectNodes().sorted)
    println(hasPath(tree1, 7))
    println(hasPath(tree1, 3))
    println(hasPath(tree1, 16))
    println(hasPath(tree1, 14))
    println(hasPath(TreeEnd, 7))
    println(findAllPaths(tree2, "10"))
    println(findAllPaths(tree3, "25"))
    println(findAllPaths(exTree, "10"))
    println(findAllPaths(TreeEnd, "25"))
    //------------------------------------------------------------------------------------------------------------------
    val anIntModifier = new Modifier[Int](100)
    println(anIntModifier.modifier)

    anIntModifier.modifier = 101
    println(anIntModifier.modifier)
    //------------------------------------------------------------------------------------------------------------------
    //    val platform: Try[Platform] = Try(LoginService.login())
    //
    //    platform match {
    //      case Success(v) =>
    //        val result = Try(v.enroll())
    //        result match {
    //          case Success(v) =>
    //            println("You have successfully enrolled in the course " + v)
    //          case Failure(e) =>
    //            println(e.getMessage)
    //        }
    //      case Failure(e) =>
    //        println(e.getMessage)
    //    }
    //------------------------------------------------------------------------------------------------------------------
    //    val network = Map("Msk" -> Set("Spb"), "Spb" -> Set("Msk"))
    //    var network2 = add(network, "Krd")
    //    network2 = add(network2, "Nvs")
    //    network2 = add(network2, "NY")
    //    network2 = add(network2, "Lon")
    //    network2 = add(network2, "Par")
    //    network2 = add(network2, "Mel")
    //    println(s"before connect $network2")
    //    network2 = connect(network2, "Msk", "Krd")
    //    network2 = connect(network2, "Msk", "Nvs")
    //    network2 = connect(network2, "Krd", "Nvs")
    //    network2 = connect(network2, "NY", "Lon")
    //    network2 = connect(network2, "Msk", "NY")
    //    network2 = connect(network2, "Mel", "Par")
    //    println(s"after connect $network2")
    //    network2 = disconnect(network2, "Nvs", "Krd")
    //    println(s"after disconnect $network2")
    //    network2 = remove(network2, "Nvs")
    //    println(s"after remove $network2")
    //    println(s"flight count ${flightCount(network2, "Msk")}")
    //    println(s"most flights ${mostFlights(network2)}")
    //    println(s"num locations with no flights ${numLocationsWithNoFlights(network2)}")
    //    println(s"are connected Krd, Msk ${isConnected(network2, "Krd", "Msk")}")
    //    println(s"are connected Krd, NY ${isConnected(network2, "Krd", "NY")}")
    //    println(s"are connected Krd, Lon ${isConnected(network2, "Krd", "Lon")}")
    //    println(s"are connected Krd, Mel ${isConnected(network2, "Krd", "Mel")}")
    //    println(s"are connected Spb, Mel ${isConnected(network2, "Spb", "Mel")}")
    //    println(s"are connected Par, Mel ${isConnected(network2, "Par", "Mel")}")
    //    println(s"are connected Msk, Lon ${isConnected(network2, "Msk", "Lon")}")
    //------------------------------------------------------------------------------------------------------------------
    //    println(countChars("Sst"))
    //------------------------------------------------------------------------------------------------------------------
    //    println(duplicate(List(1, 2, 3), 2))
    //------------------------------------------------------------------------------------------------------------------
    //    println(compare("1.0.2.03", "1.1.0") == -1)
    //    println(compare("2.1", "2.01") == 0)
    //    println(compare("3.0", "3.0.0.0") == 0)
    //    println(compare("4", "4.0.0.1") == -1)
    //    println(compare("4.0.1", "4.0.0.1") == 1)
    //    println(compare("1.10.1", "11.0.1") == -1)
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
