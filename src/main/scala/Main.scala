package Main

import Loader.console.controllers.ConsoleController
import Loader.console.views.ConsoleView

object Main extends App {
  println("Hello there")
  val controller = new ConsoleController
  val view = new ConsoleView(controller)
  view.run(args)
}