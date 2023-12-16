package UI

import UI.controllers.Controller
import UI.parsers.CommandParser
import UI.parsers.converterParsers.AsciiConverterParser
import UI.parsers.exportParsers.ExporterImplParser
import UI.parsers.filterParsers.{FilterImplParser, InvertFilterParser, RotateFilterParser, ScaleFilterParser}
import UI.parsers.loadParsers.ImageLoaderImplParser


/**
 * A simple console UI that takes in arguments and converts the image
 * @param controller - a controller that converts the image
 * @param parser - a parser thanks to which the console UI parses arguments
 */
class ConsoleUI(controller: Controller, parser: CommandParser) extends UI(controller) {
  /**
   * Connect the commands with its arguments into one string
   * @param args - the unparsed arguments
   * @return - commands with its arguments
   */
  protected def parseCommands(args: Seq[String]): Seq[String] = {
    var result = List[String]()
    var incompleteCommand = ""
    for (argument <- args) {
      if (argument.startsWith("--")) {
        if (incompleteCommand != "") {
          result = result.appended(incompleteCommand)
          incompleteCommand = ""
        }
        incompleteCommand = argument
      }
      else {
        result = result.appended(incompleteCommand + " " + argument)
        incompleteCommand = ""
      }
    }
    if (incompleteCommand != "") {
      result = result.appended(incompleteCommand)
      incompleteCommand = ""
    }
    result
  }

  /**
   * The main method that starts it all
   * @param args the arguments from command line
   */
  def run(args: Array[String]): Unit = {
    val regexExport = "--output-.*".r
    val regexImage = "--image.*".r
    val regexTable = "--(table|custom-table) .*".r
    var image = ""
    var tableType = ""
    var filters = List[String]()
    var exports = List[String]()
    val parsedCommands = parseCommands(args)
    for(command <- parsedCommands) {
      command match {
        case "--help" =>
          print(controller.showHelp())
          return
        case regexImage() =>
          image = command
        case regexExport() =>
          exports = exports.appended(command)
        case regexTable(_) =>
          tableType = command
        case _ =>
          filters = filters.appended(command)
      }
    }
    println("---Running Conversion---")
    try {
      if (tableType == "") {
        controller.makeAscii(image = parser.loaderParser.getLoader(image).loadImage(), filter = parser.filterParser.getFilterFromNames(filters), output = parser.exporterParser.getExporter(exports))
      }
      else {
        controller.makeAscii(image = parser.loaderParser.getLoader(image).loadImage(), converter = parser.converterAsciiParser.getConverter(tableType), filter = parser.filterParser.getFilterFromNames(filters), output = parser.exporterParser.getExporter(exports))
      }
      println("---Conversion Done---")
    }
    catch {
      case e: IllegalArgumentException =>
        //println(e.getMessage)
        System.err.println(e.getMessage)
    }


  }
}

object ConsoleUI {
  /**
   * Get a common command parser for the Console UI
   * @return a command parser
   */
  def commonParser: CommandParser = {
    val listFilterParsers = List(
      new InvertFilterParser,
      new RotateFilterParser,
      new ScaleFilterParser
    )

    val filterParser = new FilterImplParser(listFilterParsers)
    val loaderParser = new ImageLoaderImplParser
    val exporterParser = new ExporterImplParser
    val converterParser = new AsciiConverterParser

    new CommandParser(filterParser = filterParser, converterAsciiParser = converterParser, exporterParser = exporterParser, loaderParser = loaderParser)
  }
}
