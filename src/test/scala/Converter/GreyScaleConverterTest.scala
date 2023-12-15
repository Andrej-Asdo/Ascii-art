package Converter

import Converter.TransformationTable.TransformationTable
import Image.Pixel.{GreyScaleValue, RGBValue}
import Image.{Image, RGBImage}
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

class GreyScaleConverterTest extends FunSuite{
  test("Convert Black Image To GreyScale") {
    val greyScaleConverter = new GreyScaleConverter()
    // Mock the Image
    val blackImage = mock[RGBImage]
    when(blackImage.getPixel(any[Int], any[Int])).thenReturn(RGBValue(0, 0, 0))
    when(blackImage.getWidth).thenReturn(10)
    when(blackImage.getHeight).thenReturn(5)

    val greyScale = greyScaleConverter.convert(blackImage)
    assert(greyScale.getWidth == 10)
    assert(greyScale.getHeight == 5)
    assert(greyScale.getPixel(0, 0) == GreyScaleValue(0))
  }

}
