package Main

import UI.ConsoleUI
import UI.controllers.BasicController
import UI.parsers.converterParsers.AsciiConverterParser
import UI.parsers.exportParsers.ExporterImplParser
import UI.parsers.filterParsers.FilterImplParser
import UI.parsers.loadParsers.ImageLoaderImplParser

object Main extends App {

  val controller = new BasicController
  val parser = ConsoleUI.commonParser

  val consoleUI = new ConsoleUI(controller,parser)
  consoleUI.run(args)
}