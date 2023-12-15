package Main

import UI.ConsoleUI
import UI.controllers.BasicController
import UI.parsers.converterParsers.AsciiConverterParser
import UI.parsers.exportParsers.ExporterFileParser
import UI.parsers.filterParsers.FilterImplParser
import UI.parsers.loadParsers.ImageLoaderImplParser

object Main extends App {

  val controller = new BasicController
  val loaderParser = new ImageLoaderImplParser

  val exporterParser = new ExporterFileParser
  val converterParser = new AsciiConverterParser
  val consoleUI = new ConsoleUI(controller, loaderParser, exporterParser, converterParser)
  consoleUI.run(args)
}