package Loader

import Image.FileImage
import Image.Pixel.RGBValue
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.FunSuite

import java.io.{File, IOException}

class FileLoaderTest extends FunSuite {
  test("Load Image from NonExistent File") {
    assertThrows[IOException](new FileLoader("xerrrr.jpg").loadImage())
  }

  test("Load Image with wrong extension") {
    assertThrows[IllegalArgumentException](new FileLoader("test.tiff").loadImage())
    assertThrows[IllegalArgumentException](new FileLoader("test.gif").loadImage())
    assertThrows[IllegalArgumentException](new FileLoader("test.docx").loadImage())
    assertThrows[IllegalArgumentException](new FileLoader("test").loadImage())
  }

  test("Load JPG Image") {
    val image = new FileLoader("./images/jpg/black.jpg").loadImage()
    assert(image.getWidth == 850)
    assert(image.getHeight == 500)
    assert(image.getPixel(0,0) == RGBValue(0,0,0))
  }

  test("Load PNG Image") {
    val image = new FileLoader("./images/png/white.png").loadImage()
    assert(image.getWidth == 469)
    assert(image.getHeight == 346)
    assert(image.getPixel(0, 0) == RGBValue(255, 255, 255))
  }

  test("Load JPEG Image") {
    val image = new FileLoader("./images/jpg/red.jpeg").loadImage()
    assert(image.getWidth == 587)
    assert(image.getHeight == 411)
    assert(image.getPixel(0, 0) == RGBValue(100, 0, 0))
  }
}
