package Main

import UI.ConsoleUI
import UI.controllers.BasicController

object Main extends App {

  val controller = new BasicController
  val consoleUI = new ConsoleUI(controller)
  consoleUI.run(args)
}