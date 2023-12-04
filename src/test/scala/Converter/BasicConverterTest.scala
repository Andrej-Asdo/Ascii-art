package Converter

import Converter.TransformationTable.LinearTable.PaulBurkesTable
import Loader.FileLoader
import org.scalatest.FunSuite

class BasicConverterTest extends FunSuite{
  val basicConverter = new BasicConverter(PaulBurkesTable)
  val blackImage = new FileLoader("./images/jpg/black.jpg").loadImage()

  test("Convert Black Image") {
    val greyScale = basicConverter.convertToGreyScale(blackImage)
    val converted = basicConverter.convertToAscii(greyScale)
    assert(converted.getPixel(0,0).character == '$')
  }

  test("Black image has all same chars") {
    val greyScale = basicConverter.convertToGreyScale(blackImage)
    val converted = basicConverter.convertToAscii(greyScale)
    for(row <- 0 until converted.getHeight; col <- 0 until converted.getWidth) {
      assert(converted.getPixel(row,col).character == '$')
    }
  }

}
