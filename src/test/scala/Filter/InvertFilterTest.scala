package Filter

import Image.GreyScaleImage
import Image.Pixel.GreyScaleValue
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, times, verify, when}
import org.scalatest.FunSuite

class InvertFilterTest extends FunSuite{
  val greyScale2x2Image: GreyScaleImage = new GreyScaleImage(2, 2)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 1, 0)
    .setPixel(GreyScaleValue(4), 1, 1)

  val inverted2x2Image: GreyScaleImage = new GreyScaleImage(2, 2)
    .setPixel(GreyScaleValue(254), 0, 0)
    .setPixel(GreyScaleValue(253), 0, 1)
    .setPixel(GreyScaleValue(252), 1, 0)
    .setPixel(GreyScaleValue(251), 1, 1)

  val zeroDimImage = new GreyScaleImage(0,0)

  val greyScale2x3Image: GreyScaleImage = new GreyScaleImage(2, 3)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 0, 2)
    .setPixel(GreyScaleValue(4), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(6), 1, 2)

  val inverted2x3Image: GreyScaleImage = new GreyScaleImage(2, 3)
    .setPixel(GreyScaleValue(254), 0, 0)
    .setPixel(GreyScaleValue(253), 0, 1)
    .setPixel(GreyScaleValue(252), 0, 2)
    .setPixel(GreyScaleValue(251), 1, 0)
    .setPixel(GreyScaleValue(250), 1, 1)
    .setPixel(GreyScaleValue(249), 1, 2)

  test("Filter: Invert a 2x2 Image") {
    val filter = new InvertFilter()
    val invertedImage = filter.filterGreyScaleImage(greyScale2x2Image)
    assert(invertedImage.getHeight == 2)
    assert(invertedImage.getWidth == 2)
    for (row <- 0 until invertedImage.getHeight; col <- 0 until invertedImage.getWidth) {
      assert(invertedImage.getPixel(row, col) == inverted2x2Image.getPixel(row, col))
    }
  }

  test("Filter: Invert a Zero Dimensional Image") {
    val filter = new InvertFilter()
    val invertedImage = filter.filterGreyScaleImage(zeroDimImage)
    assert(invertedImage.getHeight == 0)
    assert(invertedImage.getWidth == 0)
  }

  test("Filter: Invert a 2x0 Dimensional Image") {
    // Mock the Image
    val image = mock[GreyScaleImage]
    when(image.getHeight).thenReturn(2)
    when(image.getWidth).thenReturn(0)

    val filter = new InvertFilter()
    val invertedImage = filter.filterGreyScaleImage(image)
    assert(invertedImage.getHeight == 2)
    assert(invertedImage.getWidth == 0)
    // Verify No Access to the Mock Image Get
    verify(image, times(0)).getPixel(any[Int], any[Int])
  }

  test("Filter: Invert a 0x2 Dimensional Image") {
    // Mock the Image
    val image = mock[GreyScaleImage]
    when(image.getHeight).thenReturn(0)
    when(image.getWidth).thenReturn(2)

    val filter = new InvertFilter()
    val invertedImage = filter.filterGreyScaleImage(image)
    assert(invertedImage.getHeight == 0)
    assert(invertedImage.getWidth == 2)
    // Verify No Access to the Mock Image Get
    verify(image, times(0)).getPixel(any[Int], any[Int])
  }

  test("Filter: Invert a 2x3 Image") {
    val filter = new InvertFilter()
    val invertedImage = filter.filterGreyScaleImage(greyScale2x3Image)
    assert(invertedImage.getHeight == 2)
    assert(invertedImage.getWidth == 3)
    for (row <- 0 until invertedImage.getHeight; col <- 0 until invertedImage.getWidth) {
      assert(invertedImage.getPixel(row, col) == inverted2x3Image.getPixel(row, col))
    }
  }
}
