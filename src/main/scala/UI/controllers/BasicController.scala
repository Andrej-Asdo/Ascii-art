package UI.controllers

import Converter.{AsciiConverter, GreyScaleConverter}
import Exporter.Exporter
import Filter.GreyScaleFilter
import Image.RGBImage

/**
 * A basic controller mainly usable for a console UI
 */
class BasicController extends Controller {
  override def showHelp(): String = {
    "---Help---\n" +
      "+++ To run the program you must define input and output image:\n" +
      "++ Input:\n" +
      "--image-random for a random image\n" +
      "--image path for an existing file image (it must be either png,jpg or jpeg image!)\n" +
      "\n" +
      "++ Output:\n" +
      "--output-console to print the converted image to console\n" +
      "--output-file path the path must exist\n" +
      "\n\n" +
      "+++ You can apply also following filters:\n" +
      "++ Scale:\n" +
      "--scale {0.25,1,4} only these values are allowed - scales the image accordingly\n" +
      "++ Invert:\n" +
      "--invert inverts the colours of the image\n" +
      "++ Rotate:\n" +
      "--rotate {+- multiples of 90} rotates the image in given direction\n" +
      "\n\n" +
      "+++ You can apply also your own table\n" +
      "++ Paul Burkes Table\n" +
      "--table PaulBurkes\n" +
      "--table SimpleBurkes\n" +
      "++ Your own linear table\n" +
      "--custom-table {chars} chars that will be used to convert the image ranging from black to white (left to right)\n"
  }

  override def makeAscii(image: RGBImage, converter: AsciiConverter, filter: GreyScaleFilter, output: Exporter): Unit = {
    val greyScaleConverter = new GreyScaleConverter()
    val greyScaleImage = greyScaleConverter.convert(image)
    val filteredImage = filter.filterImage(greyScaleImage)
    val asciiImage = converter.convert(filteredImage)
    output.`export`(asciiImage)
  }
}
