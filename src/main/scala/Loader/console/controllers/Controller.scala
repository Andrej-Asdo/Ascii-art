package Loader.console.controllers

import Converter.{BasicConverter, Converter}
import _root_.Converter.TransformationTable.LinearTable.PaulBurkesTable
import Exporter.Exporter
import Filter.Filter
import Image.Image
import _root_.Image.Pixel.RGBValue

trait Controller {
  def showHelp(): Unit

  def makeAscii(image: Image[RGBValue], converter: Converter = new BasicConverter(PaulBurkesTable), filter: Filter, output: Exporter): Unit
}
