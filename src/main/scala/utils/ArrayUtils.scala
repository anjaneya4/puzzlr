package utils

import scala.util.Random

object ArrayUtils {

  implicit class CoordinateUtils(c: Coordinates) {
    def randomNeighbor(arr: Array[Array[Int]]): Coordinates = {
      val allNeighbors = arr.getAllNeighbors(c)
      allNeighbors(Random.nextInt(allNeighbors.length))
    }
    def up = Coordinates(c.x, c.y.next)
    def down = Coordinates(c.x, c.y.prev)
    def left = Coordinates(c.x.prev, c.y)
    def right = Coordinates(c.x.next, c.y)
  }

  implicit class IntUtils(i: Int) {
    def next = i + 1
    def prev = i - 1
  }

  implicit class ArrayUtils(arr: Array[Array[Int]]) {

    def getAtCoord(coords: Coordinates): Int = {
      arr(coords.x)(coords.y)
    }

    def updateAt(coords: Coordinates, value: Int): Unit = {
      arr(coords.x)(coords.y) = value
    }

    def swap(oldPos: Coordinates, newPos: Coordinates): Array[Array[Int]] = {
      val currentElem = arr.getAtCoord(oldPos)
      arr.updateAt(oldPos, arr.getAtCoord(newPos))
      arr.updateAt(newPos, currentElem)
      arr
    }

    def move(pos: Coordinates) = {
      val newPos = pos.randomNeighbor(arr)
      arr.swap(pos, newPos)
      newPos
    }

    def locate(elem: Int): Coordinates = {
      var res = Option.empty[Coordinates]
      for (i <- 0 until arr.length) {
        val row = arr(i)
        for (j <- 0 until row.length) {
          if (elem == arr(i)(j)) res = Some(Coordinates(i, j))
        }
      }
      res.get
    }

    def getAbove(pos: Coordinates): Option[Coordinates] = {
      try {
        val up = pos.up
        arr.getAtCoord(up)
        Some(up)
      } catch {
        case e: Throwable => None
      }
    }
    def getDown(pos: Coordinates): Option[Coordinates] = {
      try {
        val down = pos.down
        arr.getAtCoord(down)
        Some(down)
      } catch {
        case e: Throwable => None
      }
    }
    def getLeft(pos: Coordinates): Option[Coordinates] = {
      try {
        val left = pos.left
        arr.getAtCoord(left)
        Some(left)
      } catch {
        case e: Throwable => None
      }
    }
    def getRight(pos: Coordinates): Option[Coordinates] = {
      try {
        val right = pos.right
        arr.getAtCoord(right)
        Some(right)
      } catch {
        case e: Throwable => None
      }
    }

    def getAllNeighbors(c: Coordinates): List[Coordinates] = {
      List(getAbove(c), getDown(c), getLeft(c), getRight(c)).filter(_.isDefined).flatten
    }
  }

  def nDimSortedArray(dim: Int): Array[Array[Int]] = {
    val state = new NumberState(0)
    List.fill(dim)(List.fill(dim)(state.getNextMod(dim * dim)).toArray).toArray
  }

  def moveZero(arr: Array[Array[Int]], times: Int): Array[Array[Int]] = {
    var pos = arr.locate(0)
    (1 to times).foreach((n) => {
      pos = arr.move(pos)
    })
    arr
  }
}

class NumberState(private var current: Int) {

  def getNextMod(divisor: Int): Int = {
    current = current + 1
    current % divisor
  }
}

// Zero based
case class Coordinates(x: Int, y: Int)