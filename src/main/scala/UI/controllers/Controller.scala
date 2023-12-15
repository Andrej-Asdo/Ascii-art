package UI.controllers

import Converter.{AsciiConverter, Converter}
import _root_.Converter.TransformationTable.LinearTable.PaulBurkesTable
import Exporter.Exporter
import Filter.Filter
import Image.{Image, RGBImage}
import _root_.Image.Pixel.RGBValue

trait Controller {
  def showHelp(): String

  def makeAscii(image: RGBImage, converter: AsciiConverter = new AsciiConverter(PaulBurkesTable), filter: Filter, output: Exporter): Unit
}
