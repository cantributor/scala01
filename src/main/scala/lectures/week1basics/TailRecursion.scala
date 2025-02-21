package lectures.week1basics

import scala.annotation.tailrec

object TailRecursion {

  def powerOfTwo(power: Int): BigInt = {
    @tailrec
    def loop(counter: Int, accumulator: BigInt = 1): BigInt = {
      if (counter < 1)
        accumulator
      else
        loop(counter - 1, accumulator * 2)
    }

    loop(power)
  }

  def addYToXNTimes(x: Int, y: Int, n: Int): Int = {
    @tailrec
    def loop(x: Int, y: Int, n: Int, accumulator: Int = x): Int = {
      if (n == 0)
        accumulator
      else
        loop(x, y, n - 1, accumulator + y)
    }

    loop(x, y, n)
  }

  def repeatIntAsManyTimesAsItHasDigits(int: Int): String = {
    @tailrec
    def loop(x: Int, accumulator: String = ""): String = {
      if (x == 0)
        accumulator
      else
        loop(x / 10, s"$accumulator${if (accumulator.isEmpty) int else s" $int"}")
    }

    loop(int)
  }

  def printRevertedSentence(input: String): Unit = {
    val words = input.split(" ")

    @tailrec
    def loop(i: Int = words.length - 1, accumulator: String = ""): String = {
      if (i < 0)
        accumulator
      else
        loop(i - 1,
          if (words(i).isEmpty) accumulator else accumulator + (if (accumulator.isEmpty) "" else " ") + words(i))
    }

    println(loop())
  }
}
