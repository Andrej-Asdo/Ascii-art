package UI

import UI.controllers.Controller

abstract class UI(controller: Controller) {
  def run(args: Array[String]): Unit
}
