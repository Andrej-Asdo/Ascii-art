package Loader.console.controllers
import Converter.Converter
import Exporter.Exporter
import Filter.Filter
import Image.Image
import _root_.Image.Pixel.RGBValue

class ConsoleController extends Controller {
  override def showHelp(): Unit = ???

  override def makeAscii(image: Image[RGBValue],converter: Converter, filter: Filter, output: Exporter): Unit = {
    val greyScaleImage = converter.convertToGreyScale(image)
    val filteredImage = filter.filterGreyScaleImage(greyScaleImage)
    val asciiImage = converter.convertToAscii(filteredImage)
    output.`export`(asciiImage)
  }
}
