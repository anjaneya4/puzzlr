package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import play.api.libs.json.Json
import services.PuzzleService

@RestController
@CrossOrigin
@RequestMapping(path = Array("/api"))
class APIController(@Autowired private val puzzleService: PuzzleService){

  @GetMapping(path = Array("/apitest"))
  def test(): String = {
    val jsonObject = Json.parse(
      """
        {
         "name": "Anjaneya Jha",
         "address" : {
           "house" : "1x",
           "street" : 12,
           "city" : "Mumbai"
         }
        }
      """)
    Json.stringify(jsonObject)
  }

  @GetMapping(path = Array("/randompuzzle"))
  def randompuzzle(): String = {
    val jsonObject = Json.parse(
      """
        [
          [2, 8, 3],
          [1, 6, 4],
          [7, 0, 5]
        ]
      """)
    Json.stringify(jsonObject)
  }

  @GetMapping(path = Array("/newpuzzle/{size}/{level}"))
  def newpuzzle(@PathVariable size: Int, @PathVariable level: Int): String = {
    val jsonObject = Json.parse(puzzleService.getNewPuzzle(size, level))
    Json.stringify(jsonObject)
  }

  @GetMapping(path = Array("/solvedpuzzle"))
  def solvedpuzzle(): String = {
    val jsonObject = Json.parse(
      """
        [
         [1, 2, 3, 4],
         [5, 6, 7, 8],
         [9, 10, 11, 0],
         [13, 14, 15, 12]
        ]
      """)
    Json.stringify(jsonObject)
  }
}
