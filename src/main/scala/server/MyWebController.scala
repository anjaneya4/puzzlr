package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._

@Controller
@RequestMapping(Array("/puzzles"))
class MyWebController @Autowired()(){

  @GetMapping
  def list(model: Model) = {
    model.addAttribute("username", "Anjaneya")
    "puzzles/mypuzzles"
  }

}
