package Converter

import Converter.TransformationTable.LinearTable.PaulBurkesTable
import Image.JPGImage
import org.scalatest.FunSuite

import java.io.File

class BasicConverterTest extends FunSuite{
  val basicConverter = new BasicConverter(PaulBurkesTable)
  val blackImage = new JPGImage(new File("./images/jpg/black.jpg"))

  test("Convert Black Image") {
    val converted = basicConverter.convertToAscii(blackImage)
    assert(converted.getCharacter(0,0) == '$')
  }

  test("Black image has all same chars") {
    val converted = basicConverter.convertToAscii(blackImage)
    for(row <- 0 until converted.getHeight; col <- 0 until converted.getWidth) {
      assert(converted.getCharacter(row,col) == '$')
    }
  }

}
