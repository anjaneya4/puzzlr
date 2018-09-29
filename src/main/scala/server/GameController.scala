package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@CrossOrigin
@RequestMapping(path = Array("/game"))
class GameController() {

  @GetMapping(path = Array("/start/{name}"))
  def startOrJoin(@PathVariable name: String): String = {
    ""
  }

}
