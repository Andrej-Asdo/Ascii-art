package Converter

import Converter.TransformationTable.LinearTable.PaulBurkesTable
import Converter.TransformationTable.TransformationTable
import Image.GreyScaleImage
import Image.Pixel.GreyScaleValue
import Loader.FileLoader
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

class AsciiConverterTest extends FunSuite{
  test("Convert Black Image to Ascii") {
    // Mock the Table
    val table = mock[TransformationTable]
    when(table.getCharacter(0)).thenReturn('$')

    val asciiConverter = new AsciiConverter(table)
    // Mock the Image
    val greyScale = mock[GreyScaleImage]
    when(greyScale.getHeight).thenReturn(10)
    when(greyScale.getWidth).thenReturn(5)
    when(greyScale.getPixel(any[Int], any[Int])).thenReturn(GreyScaleValue(0))

    val converted = asciiConverter.convert(greyScale)
    assert(converted.getWidth == 5)
    assert(converted.getHeight == 10)
    assert(converted.getPixel(0, 0).character == '$')
  }

  test("Black image has all same chars using Paul Burkes Table") {
    val asciiConverter = new AsciiConverter(PaulBurkesTable)
    val greyScaleConverter = new GreyScaleConverter()
    val blackImage = new FileLoader("./images/jpg/black.jpg").loadImage()
    val greyScale = greyScaleConverter.convert(blackImage)
    val converted = asciiConverter.convert(greyScale)
    for (row <- 0 until converted.getHeight; col <- 0 until converted.getWidth) {
      assert(converted.getPixel(row, col).character == '$')
    }
  }
}
