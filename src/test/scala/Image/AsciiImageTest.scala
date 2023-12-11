package Image

import Image.Pixel.AsciiValue
import org.scalatest.FunSuite

class AsciiImageTest extends FunSuite{
  val asciiImage: AsciiImage = new AsciiImage(3, 3)
    .setPixel(AsciiValue(1), 0, 0)
    .setPixel(AsciiValue(2), 0, 1)
    .setPixel(AsciiValue(3), 0, 2)
    .setPixel(AsciiValue(4), 1, 0)
    .setPixel(AsciiValue(5), 1, 1)
    .setPixel(AsciiValue(6), 1, 2)
    .setPixel(AsciiValue(7), 2, 0)
    .setPixel(AsciiValue(8), 2, 1)
    .setPixel(AsciiValue(9), 2, 2)

  val ascii2x3Image: AsciiImage = new AsciiImage(2, 3)
    .setPixel(AsciiValue(1), 0, 0)
    .setPixel(AsciiValue(2), 0, 1)
    .setPixel(AsciiValue(3), 0, 2)
    .setPixel(AsciiValue(4), 1, 0)
    .setPixel(AsciiValue(5), 1, 1)
    .setPixel(AsciiValue(6), 1, 2)

  test("[Ascii Image] Test Dimensions 3x3") {
    assert(asciiImage.getWidth == 3)
    assert(asciiImage.getHeight == 3)
  }

  test("[Ascii Image] Test Dimensions 2x3") {
    assert(ascii2x3Image.getWidth == 3)
    assert(ascii2x3Image.getHeight == 2)
  }

  test("[Ascii Image] Test Get 3x3") {
    assert(asciiImage.getPixel(0, 0) == AsciiValue(1))
    assert(asciiImage.getPixel(0, 2) == AsciiValue(3))
    assert(asciiImage.getPixel(1, 1) == AsciiValue(5))
    assert(asciiImage.getPixel(2, 2) == AsciiValue(9))
  }

  test("[Ascii Image] Test Get 2x3") {
    assert(ascii2x3Image.getPixel(0, 2) == AsciiValue(3))
    assert(ascii2x3Image.getPixel(1, 1) == AsciiValue(5))
    assert(ascii2x3Image.getPixel(0, 0) == AsciiValue(1))
    assert(ascii2x3Image.getPixel(1, 2) == AsciiValue(6))
  }

  test("[Ascii Image] Test Set 3x3") {
    asciiImage.setPixel(AsciiValue(20), 0, 0)
    asciiImage.setPixel(AsciiValue(22), 0, 2)
    asciiImage.setPixel(AsciiValue(24), 1, 1)
    asciiImage.setPixel(AsciiValue(26), 2, 2)
    assert(asciiImage.getPixel(0, 0) == AsciiValue(20))
    assert(asciiImage.getPixel(0, 2) == AsciiValue(22))
    assert(asciiImage.getPixel(1, 1) == AsciiValue(24))
    assert(asciiImage.getPixel(2, 2) == AsciiValue(26))
  }

  test("[Ascii Image] Test Set 2x3") {
    asciiImage.setPixel(AsciiValue(20), 0, 0)
    asciiImage.setPixel(AsciiValue(22), 0, 2)
    asciiImage.setPixel(AsciiValue(24), 1, 1)
    asciiImage.setPixel(AsciiValue(26), 1, 2)
    assert(asciiImage.getPixel(0, 2) == AsciiValue(22))
    assert(asciiImage.getPixel(1, 1) == AsciiValue(24))
    assert(asciiImage.getPixel(0, 0) == AsciiValue(20))
    assert(asciiImage.getPixel(1, 2) == AsciiValue(26))
  }

  test("[Ascii Image] Test Invalid Get 3x3") {
    assertThrows[IndexOutOfBoundsException](asciiImage.getPixel(5, 5))
    assertThrows[IndexOutOfBoundsException](asciiImage.getPixel(0, 5))
    assertThrows[IndexOutOfBoundsException](asciiImage.getPixel(5, 0))
    assertThrows[IndexOutOfBoundsException](asciiImage.getPixel(3, 3))
  }

  test("[Ascii Image] Test Invalid Set 3x3") {
    assertThrows[IndexOutOfBoundsException](asciiImage.setPixel(AsciiValue(20), 5, 5))
    assertThrows[IndexOutOfBoundsException](asciiImage.setPixel(AsciiValue(20), 0, 5))
    assertThrows[IndexOutOfBoundsException](asciiImage.setPixel(AsciiValue(20), 5, 0))
    assertThrows[IndexOutOfBoundsException](asciiImage.setPixel(AsciiValue(20), 3, 3))
  }

  test("[Ascii Image] Test Invalid Get 2x3") {
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.getPixel(5, 5))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.getPixel(0, 5))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.getPixel(5, 0))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.getPixel(2, 3))
  }

  test("[Ascii Image] Test Invalid Set 2x3") {
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.setPixel(AsciiValue(20), 5, 5))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.setPixel(AsciiValue(20), 0, 5))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.setPixel(AsciiValue(20), 5, 0))
    assertThrows[IndexOutOfBoundsException](ascii2x3Image.setPixel(AsciiValue(20), 2, 3))
  }
}
