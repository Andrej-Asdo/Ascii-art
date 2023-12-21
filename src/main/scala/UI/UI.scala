package UI

import UI.controllers.Controller

/**
 * An abstract UI for the app
 * @param controller a controller that executes the tasks
 */
abstract class UI(controller: Controller) {

  /**
   * Main method that runs the app
   * @param args arguments passed at the startup
   */
  def run(args: Array[String]): Unit
}
