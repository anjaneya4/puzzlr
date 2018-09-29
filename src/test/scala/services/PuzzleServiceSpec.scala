package services

import org.junit.runner.RunWith
import org.scalactic.Or
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PuzzleServiceSpec extends WordSpec with Matchers {
  "A PuzzleService instance" should {
    val service = new PuzzleService
    "return puzzle of type Array[Array[Int]]" in {
      val result = service.getNewPuzzle(3, 0)
      result shouldNot be (null)
    }
  }
}
