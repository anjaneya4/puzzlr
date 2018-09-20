package services

import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PuzzleServiceTest extends WordSpec with Matchers {
  "A PuzzleService instance" should {
    val service = new PuzzleService
    "return puzzle of type Array[Array[Int]]" in {
      val result = service.getNewPuzzle(3, 0)
      result shouldBe s"[[1,2,3],[4,5,6],[7,8,0]]"
    }
  }
}
