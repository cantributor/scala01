package lectures

import lectures.week1basics.TailRecursion.{addYToXNTimes, powerOfTwo, printRevertedSentence, repeatIntAsManyTimesAsItHasDigits}

object Main {

  def main(fArgs: Array[String]): Unit = {
    println(powerOfTwo(64))

//    println(repeatIntAsManyTimesAsItHasDigits(addYToXNTimes(fArgs(0).toInt, fArgs(1).toInt, fArgs(2).toInt)) +
//      " is the result")

    println(repeatIntAsManyTimesAsItHasDigits(addYToXNTimes(100, 40, 10)) +
      " is the result")

    printRevertedSentence("I like     Scala")
  }
}
