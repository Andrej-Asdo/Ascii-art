package UI

import Converter.{BasicConverter, Converter}
import _root_.Converter.TransformationTable.LinearTable.{LinearTable, PaulBurkesTable, SimpleBurkes}
import Exporter.{ConsoleExporter, Exporter, FileExporter, MixedExporter}
import Filter.{Filter, InvertFilter, MixedFilter, RotateFilter, ScaleFilter}
import Image.{FileImage, GeneratedImage, Image}
import UI.controllers.Controller
import _root_.Image.Pixel.RGBValue

import java.io.File

/**
 * A simple console UI that takes in arguments and converts the image
 * @param controller - a controller that converts the image
 */
class ConsoleUI(controller: Controller) extends UI(controller) {
  /**
   * Gets filters from arguments
   * @param filterNames - the names and arguments of all filters that will be used
   * @return filter or filters that will be used
   * @throws IllegalArgumentException - a filter is not recognized
   */
  protected def getFilterFromNames(filterNames: Seq[String]): Filter = {
    var filters = List[Filter]()
    for(filter <- filterNames) {
      if (filter.contains("--invert"))
        filters = filters.appended(new InvertFilter())

      else if (filter.startsWith("--rotate ")) {
        // Make regex
        val rotateRegex = "--rotate ([+,-]*[0-9]+)".r
        filter match {
          case rotateRegex(value) =>
            filters = filters.appended(new RotateFilter(value.toInt))
        }
      }

      else if (filter.startsWith("--scale ")) {
        // Make regex
        val scaleRegex = "--scale ([0-9]+[.]*[0-9]*)".r
        filter match {
          case scaleRegex(value) =>
            filters = filters.appended(new ScaleFilter(value.toDouble))
        }
      }

      else {
        throw new IllegalArgumentException("Invalid filter used or invalid parameters of a filter given!")
      }

    }
    new MixedFilter(filters)
  }

  /**
   * Get all types of exporters that user wishes to use.
   * @param exportArguments - a string representation of exporters
   * @return all exporters that will be used
   * @throws IllegalArgumentException - if export way is illegal
   */
  protected def getExportFile(exportArguments: Seq[String]): Exporter = {
    var exporters = List[Exporter]()
    val exportRegex = "--output-file (.*)".r
    for(argument <- exportArguments) {
      argument match {

        //Regex ok, we have the path
        case exportRegex(path) =>
          exporters = exporters.appended(new FileExporter(new File(path)))

        // Only output to console
        case "--output-console" =>
          exporters = exporters.appended(ConsoleExporter)

        case _ =>
          throw new IllegalArgumentException("Invalid type of output! Use --output-console and/or --output-file path!")
      }
    }
    new MixedExporter(exporters)
  }

  /**
   * Gets image from the given arguments (either generated or path)
   * @param image - an argument, that of wished image
   * @return a chosen image type
   * @throws IllegalArgumentException - if invalid argument or extension is provided
   */
  protected def getImage(image: String): Image[RGBValue] = {
    val importRegex = "--image (.*(png|jpg|jpeg))".r
    image match {
      // Random image will be used
      case "--image-random" =>
        new GeneratedImage()
      // An existing image will be used
      case importRegex(path,_) =>
        new FileImage(new File(path))
      case _ => throw new IllegalArgumentException("Invalid image argument or extension! Use --image-random or --image path.(png|jpg|jpeg)!")
    }
  }

  /**
   * Gets the converter that user wishes to use for converting his/hers image
   * @param tableCommand - an argument for usage of a given table or converter
   * @return a converter to convert an image
   */
  protected def getConverter(tableCommand: String): Converter = {
    val customTableRegex = "--custom-table (.*)".r
    tableCommand match {
      // Use custom table
      case customTableRegex(table) =>
        new BasicConverter(new LinearTable(table))
      // Use Simple Bourkes table
      case "--table SimpleBurkes" =>
        new BasicConverter(SimpleBurkes)
      // Use Paul Burkes tables or default to it
      case "--table PaulBurkes" | _ =>
        new BasicConverter(PaulBurkesTable)
    }
  }

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
        controller.makeAscii(image = getImage(image), filter = getFilterFromNames(filters), output = getExportFile(exports))
      }
      else {
        controller.makeAscii(image = getImage(image), converter = getConverter(tableType), filter = getFilterFromNames(filters), output = getExportFile(exports))
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
