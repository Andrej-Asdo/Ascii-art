package Main

import UI.ConsoleUI
import UI.controllers.ConsoleController

object Main extends App {

  val controller = new ConsoleController
  val consoleUI = new ConsoleUI(controller)
  consoleUI.run(args)
}