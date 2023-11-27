package Loader.console.views

import Converter.{BasicConverter, Converter}
import _root_.Converter.TransformationTable.LinearTable.{LinearTable, PaulBurkesTable}
import Exporter.{ConsoleExporter, Exporter, FileExporter, MixedExporter}
import Filter.{Filter, InvertFilter, MixedFilter, RotateFilter, ScaleFilter}
import Image.{FileImage, GeneratedImage, Image}
import _root_.Image.Pixel.RGBValue
import Loader.console.controllers.Controller

import java.io.File

class ConsoleView(controller: Controller) {
  protected def getFilterFromNames(filterNames: Seq[String]): Filter = {
    var filters = List[Filter]()
    for(filter <- filterNames) {
      if (filter.contains("--invert"))
        filters = filters.appended(new InvertFilter())

      if (filter.startsWith("--rotate")) {
        // Make regex
        val rotateRegex = "--rotate ([+,-]*[0-9]+)".r
        filter match {
          case rotateRegex(value) =>
            filters = filters.appended(new RotateFilter(value.toInt))
        }
      }

      if (filter.startsWith("--scale")) {
        // Make regex
        val scaleRegex = "--scale ([0-9]+[.]*[0-9]*)".r
        filter match {
          case scaleRegex(value) =>
            filters = filters.appended(new ScaleFilter(value.toDouble))
        }
      }

    }
    new MixedFilter(filters)
  }

  protected def getExportFile(exportArguments: Seq[String]): Exporter = {
    var exporters = List[Exporter]()
    val exportRegex = "--output-file (.*)".r
    for(argument <- exportArguments) {
      argument match {

        //Regex ok, we have the path
        case exportRegex(path) =>
          exporters = exporters.appended(new FileExporter(new File(path)))

        //
        case "--output-console" =>
          exporters = exporters.appended(ConsoleExporter)
      }
    }
    new MixedExporter(exporters)
  }

  protected def getImage(image: String): Image[RGBValue] = {
    val importRegex = "--image (.*(png|jpg|jpeg))".r
    image match {
      case "--image-random" =>
        new GeneratedImage()
      case importRegex(path,_) =>
        new FileImage(new File(path))
      case _ => throw new Exception("Invalid image argument or extension")
    }
  }

  protected def getConverter(tableCommand: String): Converter = {
    val customTableRegex = "--custom-table (.*)".r
    tableCommand match {
      case "--table PaulBurkes" =>
        new BasicConverter(PaulBurkesTable)
      case customTableRegex(table) =>
        new BasicConverter(new LinearTable(table))
    }
  }

  protected def processArgument(argument: String): Unit = {
    if(argument == "help") {
      controller.showHelp()
    }

  }

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
        case regexImage() =>
          image = command
        case regexExport() =>
          exports = exports.appended(command)
        case regexTable() =>
          tableType = command
        case _ =>
          filters = filters.appended(command)
      }
    }

    if(tableType == "") {
      controller.makeAscii(image = getImage(image), filter = getFilterFromNames(filters), output = getExportFile(exports))
    }
    else {
      controller.makeAscii(image = getImage(image),converter = getConverter(tableType), filter = getFilterFromNames(filters), output = getExportFile(exports))
    }

  }
}
