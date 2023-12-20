package Loader

import Image.Pixel.RGBValue
import org.scalatest.FunSuite

import java.io.IOException

class PNGFileLoaderTest extends FunSuite {
  test("Load Image from NonExistent File") {
    assertThrows[IOException](new PNGFileLoader("xerrrr.png").loadImage())
  }

  test("Load Image with wrong extension") {
    assertThrows[IllegalArgumentException](new PNGFileLoader("test.tiff").loadImage())
    assertThrows[IllegalArgumentException](new PNGFileLoader("test.gif").loadImage())
    assertThrows[IllegalArgumentException](new PNGFileLoader("test.docx").loadImage())
    assertThrows[IllegalArgumentException](new PNGFileLoader("test").loadImage())
  }

  test("Load PNG Image") {
    val image = new PNGFileLoader("./images/png/white.png").loadImage()
    assert(image.getWidth == 469)
    assert(image.getHeight == 346)
    assert(image.getPixel(0, 0) == RGBValue(255, 255, 255))
  }
}
