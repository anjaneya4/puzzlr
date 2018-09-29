package domain.numberpuzzles

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class NumberPuzzleSpec extends WordSpec with Matchers {

  "A NumberPuzzle instance" when {
    "size 3 and leve 1" should {
      "return puzzle of type Array[Array[Int]]" in {
        val result = NumberPuzzleGenerator.generatePuzzle(3, 1)
        result.getClass shouldBe classOf[Array[Array[Int]]]
      }
      "return puzzle of size 3 * 3" in {
        val result = NumberPuzzleGenerator.generatePuzzle(3, 1)
        result.size shouldBe 3
        result(0).size shouldBe 3
      }
      "return something more than empty string" in {
        val possibles = List(
          Array(
            Array(1,2,3),
            Array(4,5,0),
            Array(7,8,6)),
          Array(
            Array(1,2,3),
            Array(4,5,6),
            Array(7,0,8))
        )
        val res = NumberPuzzleGenerator.generatePuzzle(3, 1)
        (res.length > 1) should be (true)
      }
    }
  }
}
