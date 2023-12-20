package Loader

import Image.Pixel.RGBValue
import org.scalatest.FunSuite

import java.io.IOException

class JPEGFileLoaderTest extends FunSuite {
  test("Load Image from NonExistent File") {
    assertThrows[IOException](new JPEGFileLoader("xerrrr.jpeg").loadImage())
  }

  test("Load Image with wrong extension") {
    assertThrows[IllegalArgumentException](new JPEGFileLoader("test.tiff").loadImage())
    assertThrows[IllegalArgumentException](new JPEGFileLoader("test.gif").loadImage())
    assertThrows[IllegalArgumentException](new JPEGFileLoader("test.docx").loadImage())
    assertThrows[IllegalArgumentException](new JPEGFileLoader("test").loadImage())
  }

  test("Load JPEG Image") {
    val image = new JPEGFileLoader("./images/jpg/red.jpeg").loadImage()
    assert(image.getWidth == 587)
    assert(image.getHeight == 411)
    assert(image.getPixel(0, 0) == RGBValue(100, 0, 0))
  }
}
