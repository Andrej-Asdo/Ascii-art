package Loader

import Image.Pixel.RGBValue
import org.scalatest.FunSuite

import java.io.IOException

class JPGFileLoaderTest extends FunSuite {
  test("Load Image from NonExistent File") {
    assertThrows[IOException](new JPGFileLoader("xerrrr.jpg").loadImage())
  }

  test("Load Image with wrong extension") {
    assertThrows[IllegalArgumentException](new JPGFileLoader("test.tiff").loadImage())
    assertThrows[IllegalArgumentException](new JPGFileLoader("test.gif").loadImage())
    assertThrows[IllegalArgumentException](new JPGFileLoader("test.docx").loadImage())
    assertThrows[IllegalArgumentException](new JPGFileLoader("test").loadImage())
  }

  test("Load JPG Image") {
    val image = new JPGFileLoader("./images/jpg/black.jpg").loadImage()
    assert(image.getWidth == 850)
    assert(image.getHeight == 500)
    assert(image.getPixel(0, 0) == RGBValue(0, 0, 0))
  }
}
