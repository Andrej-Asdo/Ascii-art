package Image

import Image.Pixel.GreyScaleValue
import org.scalatest.FunSuite

class GreyScaleImageTest extends FunSuite{
  val greyScaleImage: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 0, 2)
    .setPixel(GreyScaleValue(4), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(6), 1, 2)
    .setPixel(GreyScaleValue(7), 2, 0)
    .setPixel(GreyScaleValue(8), 2, 1)
    .setPixel(GreyScaleValue(9), 2, 2)

  val greyScale2x3Image: GreyScaleImage = new GreyScaleImage(2, 3)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 0, 2)
    .setPixel(GreyScaleValue(4), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(6), 1, 2)

  test("[GreyScale Image] Test Dimensions 3x3") {
    assert(greyScaleImage.getWidth == 3)
    assert(greyScaleImage.getHeight == 3)
  }

  test("[GreyScale Image] Test Dimensions 2x3") {
    assert(greyScale2x3Image.getWidth == 3)
    assert(greyScale2x3Image.getHeight == 2)
  }

  test("[GreyScale Image] Test Get 3x3") {
    assert(greyScaleImage.getPixel(0,0) == GreyScaleValue(1))
    assert(greyScaleImage.getPixel(0,2) == GreyScaleValue(3))
    assert(greyScaleImage.getPixel(1,1) == GreyScaleValue(5))
    assert(greyScaleImage.getPixel(2,2) == GreyScaleValue(9))
  }

  test("[GreyScale Image] Test Get 2x3") {
    assert(greyScale2x3Image.getPixel(0, 0) == GreyScaleValue(1))
    assert(greyScale2x3Image.getPixel(0, 2) == GreyScaleValue(3))
    assert(greyScale2x3Image.getPixel(1, 1) == GreyScaleValue(5))
    assert(greyScale2x3Image.getPixel(1, 2) == GreyScaleValue(6))
  }

  test("[GreyScale Image] Test Set 3x3") {
    greyScaleImage.setPixel(GreyScaleValue(20),0,0)
    greyScaleImage.setPixel(GreyScaleValue(22),0,2)
    greyScaleImage.setPixel(GreyScaleValue(24),1,1)
    greyScaleImage.setPixel(GreyScaleValue(26),2,2)
    assert(greyScaleImage.getPixel(0, 0) == GreyScaleValue(20))
    assert(greyScaleImage.getPixel(0, 2) == GreyScaleValue(22))
    assert(greyScaleImage.getPixel(1, 1) == GreyScaleValue(24))
    assert(greyScaleImage.getPixel(2, 2) == GreyScaleValue(26))
  }

  test("[GreyScale Image] Test Set 2x3") {
    greyScaleImage.setPixel(GreyScaleValue(20), 0, 0)
    greyScaleImage.setPixel(GreyScaleValue(22), 0, 2)
    greyScaleImage.setPixel(GreyScaleValue(24), 1, 1)
    greyScaleImage.setPixel(GreyScaleValue(26), 1, 2)
    assert(greyScaleImage.getPixel(0, 0) == GreyScaleValue(20))
    assert(greyScaleImage.getPixel(0, 2) == GreyScaleValue(22))
    assert(greyScaleImage.getPixel(1, 1) == GreyScaleValue(24))
    assert(greyScaleImage.getPixel(1, 2) == GreyScaleValue(26))
  }

  test("[GreyScale Image] Test Invalid Get 3x3") {
    assertThrows[IndexOutOfBoundsException](greyScaleImage.getPixel(5,5))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.getPixel(0,5))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.getPixel(5,0))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.getPixel(3,3))
  }

  test("[GreyScale Image] Test Invalid Set 3x3") {
    assertThrows[IndexOutOfBoundsException](greyScaleImage.setPixel(GreyScaleValue(20),5, 5))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.setPixel(GreyScaleValue(20),0, 5))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.setPixel(GreyScaleValue(20),5, 0))
    assertThrows[IndexOutOfBoundsException](greyScaleImage.setPixel(GreyScaleValue(20),3, 3))
  }

  test("[GreyScale Image] Test Invalid Get 2x3") {
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.getPixel(5, 5))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.getPixel(0, 5))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.getPixel(5, 0))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.getPixel(2, 3))
  }

  test("[GreyScale Image] Test Invalid Set 2x3") {
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.setPixel(GreyScaleValue(20), 5, 5))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.setPixel(GreyScaleValue(20), 0, 5))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.setPixel(GreyScaleValue(20), 5, 0))
    assertThrows[IndexOutOfBoundsException](greyScale2x3Image.setPixel(GreyScaleValue(20), 2, 3))
  }
}
