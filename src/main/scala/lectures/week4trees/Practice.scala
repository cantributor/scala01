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
}

case class Node[+T](
                     override val value: T,
                     override val leftChild: BinaryTree[T],
                     override val rightChild: BinaryTree[T])
  extends BinaryTree[T] {

  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = leftChild.isEmpty & rightChild.isEmpty

  override def collectLeaves: List[BinaryTree[T]] = {

    @tailrec
    def loop(toInspect: List[BinaryTree[T]], accumulator: List[BinaryTree[T]]): List[BinaryTree[T]] = {
      if (toInspect.isEmpty)
        accumulator
      else {
        val forAccumulation = toInspect.flatMap(bt => List(bt.leftChild, bt.rightChild).filter(_.isLeaf))
        val newToInspect = toInspect.flatMap(bt => List(bt.leftChild, bt.rightChild).filterNot(_.isEmpty))
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
        val newToInspect = toInspect.flatMap(bt => List(bt.leftChild, bt.rightChild).filterNot(_.isEmpty))
        loop(newToInspect, currLevel + 1, accumulator ::: forAccumulation)
      }
    }

    loop(List(this), 0, List())
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
}

val tree = Node(1,
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