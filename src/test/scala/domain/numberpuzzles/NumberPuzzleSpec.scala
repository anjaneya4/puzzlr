package domain.numberpuzzles

import java.util

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

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
      "return once moved 0 for level 1" in {
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
        possibles.map(_.flatten.mkString).filter(_.equals(res.flatten.mkString)).length shouldBe 1
      }
    }
  }
}
