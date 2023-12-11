package Converter

import Converter.TransformationTable.LinearTable.PaulBurkesTable
import Converter.TransformationTable.TransformationTable
import Image.{GreyScaleImage, Image}
import Loader.FileLoader
import _root_.Image.Pixel.{GreyScaleValue, Pixel, RGBValue}
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

class BasicConverterTest extends FunSuite{


  test("Convert Black Image To GreyScale") {
    // Mock the Table
    val table = mock[TransformationTable]

    val basicConverter = new BasicConverter(table)
    // Mock the Image
    val blackImage = mock[Image[RGBValue]]
    when(blackImage.getPixel(any[Int], any[Int])).thenReturn(RGBValue(0, 0, 0))
    when(blackImage.getWidth).thenReturn(10)
    when(blackImage.getHeight).thenReturn(5)

    val greyScale = basicConverter.convertToGreyScale(blackImage)
    assert(greyScale.getWidth == 10)
    assert(greyScale.getHeight == 5)
    assert(greyScale.getPixel(0,0) == GreyScaleValue(0))
  }

  test("Convert Black Image to Ascii") {
    // Mock the Table
    val table = mock[TransformationTable]
    when(table.getCharacter(0)).thenReturn('$')

    val basicConverter = new BasicConverter(table)
    // Mock the Image
    val greyScale = mock[GreyScaleImage]
    when(greyScale.getHeight).thenReturn(10)
    when(greyScale.getWidth).thenReturn(5)
    when(greyScale.getPixel(any[Int],any[Int])).thenReturn(GreyScaleValue(0))

    val converted = basicConverter.convertToAscii(greyScale)
    assert(converted.getWidth == 5)
    assert(converted.getHeight == 10)
    assert(converted.getPixel(0, 0).character == '$')
  }

  test("Black image has all same chars using Paul Burkes Table") {
    val basicConverter = new BasicConverter(PaulBurkesTable)
    val blackImage = new FileLoader("./images/jpg/black.jpg").loadImage()
    val greyScale = basicConverter.convertToGreyScale(blackImage)
    val converted = basicConverter.convertToAscii(greyScale)
    for(row <- 0 until converted.getHeight; col <- 0 until converted.getWidth) {
      assert(converted.getPixel(row,col).character == '$')
    }
  }

}
