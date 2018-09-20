package services

import domain.numberpuzzles.NumberPuzzleGenerator
import org.springframework.stereotype.Component
import play.api.libs.json.{JsObject, Json}

@Component
class PuzzleService{

  def getNewPuzzle(size: Int, level: Int): String = {
    Json.toJson(NumberPuzzleGenerator.generatePuzzle(size, level)).toString()
  }

}
