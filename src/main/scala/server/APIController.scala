package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import play.api.libs.json.Json

@RestController
@CrossOrigin
@RequestMapping(path = Array("/api"))
class APIController @Autowired()(){

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

}
