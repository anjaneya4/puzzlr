package domain.numberpuzzles

import utils.ArrayUtils

object NumberPuzzleGenerator {
  def generatePuzzle(size: Int, level: Int): Array[Array[Int]] = {
    val solvedPuzzle = ArrayUtils.nDimSortedArray(size)
    ArrayUtils.moveZero(solvedPuzzle, level * 2 + 3)
  }
}