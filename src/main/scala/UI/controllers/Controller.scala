package UI.controllers

import Converter.AsciiConverter
import _root_.Converter.TransformationTable.LinearTable.PaulBurkesTable
import Exporter.Exporter
import Filter.GreyScaleFilter
import Image.RGBImage

/**
 * Executes the wished commands
 */
trait Controller {

  /**
   * Show help
   * @return a formatted string that shows commands to use this app
   */
  def showHelp(): String

  /**
   * Convert an image to Ascii image
   * @param image - the image to be converted
   * @param converter - the converter used for Ascii Conversion
   * @param filter - the filters to be applied
   * @param output - the output destination for the ascii image
   */
  def makeAscii(image: RGBImage, converter: AsciiConverter = new AsciiConverter(PaulBurkesTable), filter: GreyScaleFilter, output: Exporter): Unit
}
