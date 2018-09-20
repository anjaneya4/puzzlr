package server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(Array("services", "server"))
class Application {
}

object Application extends App {
  SpringApplication.run(classOf[Application]);
}
