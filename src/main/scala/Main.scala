package Main

import UI.ConsoleUI
import UI.controllers.BasicController

object Main extends App {
  // Get the wished controller and parser
  val controller = new BasicController
  val parser = ConsoleUI.commonParser

  // Get the UI
  val consoleUI = new ConsoleUI(controller,parser)

  // Run the app
  consoleUI.run(args)
}