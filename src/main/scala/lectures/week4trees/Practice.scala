package lectures.week4trees

import scala.annotation.tailrec

abstract class BinaryTree[+T] {
  def value: T // значение узла

  def leftChild: BinaryTree[T] // левый потомок

  def rightChild: BinaryTree[T] // правый потомок

  def isEmpty: Boolean

  def isLeaf: Boolean

  def collectLeaves: List[BinaryTree[T]]

  def countLeaves: Int

  def nodesAtLevel(level: Int): List[BinaryTree[T]]

  def collectNodes(): List[T]
}

case class Node[+T](
                     override val value: T,
                     override val leftChild: BinaryTree[T],
                     override val rightChild: BinaryTree[T])
  extends BinaryTree[T] {

  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = leftChild.isEmpty & rightChild.isEmpty

  private def nextToInspect[S >: T](toInspect: List[BinaryTree[S]]) =
    toInspect.flatMap(bt => List(bt.leftChild, bt.rightChild).filterNot(_.isEmpty))

  override def collectLeaves: List[BinaryTree[T]] = {

    @tailrec
    def loop(toInspect: List[BinaryTree[T]], accumulator: List[BinaryTree[T]]): List[BinaryTree[T]] = {
      if (toInspect.isEmpty)
        accumulator
      else {
        val forAccumulation = toInspect.flatMap(bt => List(bt.leftChild, bt.rightChild).filter(_.isLeaf))
        val newToInspect: List[BinaryTree[T]] = nextToInspect(toInspect)
        loop(newToInspect, accumulator ::: forAccumulation)
      }
    }

    loop(List(this), List())
  }

  override def countLeaves: Int = collectLeaves.size

  override def nodesAtLevel(level: Int): List[BinaryTree[T]] = {
    @tailrec
    def loop(toInspect: List[BinaryTree[T]], currLevel: Int, accumulator: List[BinaryTree[T]]): List[BinaryTree[T]] = {
      if (currLevel > level || toInspect.isEmpty)
        accumulator
      else {
        val forAccumulation = if (currLevel == level) toInspect else List()
        val newToInspect: List[BinaryTree[T]] = nextToInspect(toInspect)
        loop(newToInspect, currLevel + 1, accumulator ::: forAccumulation)
      }
    }

    loop(List(this), 0, List())
  }

  override def collectNodes(): List[T] = {

    @tailrec
    def loop(toInspect: List[BinaryTree[T]], accumulator: List[BinaryTree[T]]): List[BinaryTree[T]] = {
      if (toInspect.isEmpty)
        accumulator
      else {
        val accumulated = accumulator ::: toInspect
        val newToInspect: List[BinaryTree[T]] = nextToInspect(toInspect)
        loop(newToInspect, accumulated)
      }
    }

    loop(List(this), List()).map(_.value)
  }
}

case object TreeEnd extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException

  override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

  override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false

  override def collectLeaves: List[BinaryTree[Nothing]] = List()

  override def countLeaves: Int = 0

  override def nodesAtLevel(level: Int): List[BinaryTree[Nothing]] = List()

  override def collectNodes(): List[Nothing] = List()
}

def hasPath(tree: BinaryTree[Int], target: Int): Boolean = {
  @tailrec
  def loop(accumulator: List[List[BinaryTree[Int]]]): List[List[BinaryTree[Int]]] = {
    val toInspect = accumulator.filter(path => !path.last.isEmpty && !path.last.isLeaf)
    if (toInspect.isEmpty)
      accumulator
    else {
      val ready = accumulator.filter(path => path.last.isLeaf)
      val forAccumulation = toInspect
        .flatMap(path => List(path :+ path.last.leftChild, path :+ path.last.rightChild)
          .filter(path => !path.last.isEmpty))
      loop(ready ::: forAccumulation)
    }
  }

  loop(List(List(tree)))
    .map(path => path.filter(!_.isEmpty).foldLeft(0)((sum, node) => sum + node.value))
    .contains(target)
}

def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
  @tailrec
  def loop(accumulator: List[List[BinaryTree[String]]]): List[List[BinaryTree[String]]] = {
    val toInspect = accumulator.filter(path => !path.last.isEmpty && !path.last.isLeaf)
    if (toInspect.isEmpty)
      accumulator
    else {
      val ready = accumulator.filter(path => path.last.isLeaf)
      val forAccumulation = toInspect
        .flatMap(path => List(path :+ path.last.leftChild, path :+ path.last.rightChild)
          .filter(path => !path.last.isEmpty))
      loop(ready ::: forAccumulation)
    }
  }

  loop(List(List(tree)))
    .filter(path => !path.last.isEmpty)
    .filter(path => target.toInt == path.foldLeft(0)((sum, node) => sum + node.value.toInt))
    .map(path => path.map(_.value))
}

val tree1 = Node(1,
  Node(2,
    Node(4,
      TreeEnd,
      TreeEnd),
    Node(5,
      TreeEnd,
      Node(8,
        TreeEnd,
        TreeEnd))),
  Node(3,
    Node(6,
      TreeEnd,
      TreeEnd),
    Node(7,
      TreeEnd,
      TreeEnd)))

val tree2 = Node("1",
  Node("2",
    Node("4",
      TreeEnd,
      TreeEnd),
    Node("5",
      TreeEnd,
      Node("8",
        TreeEnd,
        TreeEnd))),
  Node("3",
    Node("6",
      TreeEnd,
      TreeEnd),
    Node("7",
      TreeEnd,
      TreeEnd))
)

val tree3 = Node("1",
  Node("12",
    Node("4",
      TreeEnd,
      Node("8", TreeEnd, TreeEnd)),
    Node("5",
      Node("7", TreeEnd, TreeEnd),
      TreeEnd)),
  Node("3",
    Node("6", TreeEnd, TreeEnd),
    Node("7", Node("10", Node("4", TreeEnd, TreeEnd), TreeEnd), TreeEnd))
)