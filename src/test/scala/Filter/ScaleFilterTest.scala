package Filter

import Image.GreyScaleImage
import Image.Pixel.GreyScaleValue
import org.mockito.ArgumentMatchersSugar.any
import org.mockito.MockitoSugar.{mock, times, verify, verifyZeroInteractions, when}
import org.scalatest.FunSuite

class ScaleFilterTest extends FunSuite{
  val greyScaleImage: GreyScaleImage = new GreyScaleImage(2, 2)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 1, 0)
    .setPixel(GreyScaleValue(4), 1, 1)

  val scaledFourTimes: GreyScaleImage = new GreyScaleImage(4, 4)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(1), 0, 1)
    .setPixel(GreyScaleValue(2), 0, 2)
    .setPixel(GreyScaleValue(2), 0, 3)
    .setPixel(GreyScaleValue(1), 1, 0)
    .setPixel(GreyScaleValue(1), 1, 1)
    .setPixel(GreyScaleValue(2), 1, 2)
    .setPixel(GreyScaleValue(2), 1, 3)
    .setPixel(GreyScaleValue(3), 2, 0)
    .setPixel(GreyScaleValue(3), 2, 1)
    .setPixel(GreyScaleValue(4), 2, 2)
    .setPixel(GreyScaleValue(4), 2, 3)
    .setPixel(GreyScaleValue(3), 3, 0)
    .setPixel(GreyScaleValue(3), 3, 1)
    .setPixel(GreyScaleValue(4), 3, 2)
    .setPixel(GreyScaleValue(4), 3, 3)

  val scaledQuartered: GreyScaleImage = new GreyScaleImage(1,1)
    .setPixel(GreyScaleValue(1), 0,0)

  test("Filter: Scale Image To 4 Times") {
    val filter = new ScaleFilter(4)
    val scaledImage = filter.filterImage(greyScaleImage)
    assert(scaledImage.getHeight == 4)
    assert(scaledImage.getWidth == 4)
    for (row <- 0 until scaledImage.getHeight; col <- 0 until scaledImage.getWidth) {
      assert(scaledImage.getPixel(row, col) == scaledFourTimes.getPixel(row, col))
    }
  }

  test("Filter: Scale Image To 0.25 Times") {
    val filter = new ScaleFilter(0.25)
    val scaledImage = filter.filterImage(greyScaleImage)
    assert(scaledImage.getHeight == 1)
    assert(scaledImage.getWidth == 1)
    for (row <- 0 until scaledImage.getHeight; col <- 0 until scaledImage.getWidth) {
      assert(scaledImage.getPixel(row, col) == scaledQuartered.getPixel(row, col))
    }
  }

  test("Filter: Scale Image With Invalid Scale Double") {
    val filter = new ScaleFilter(0.56)
    assertThrows[IllegalArgumentException](filter.filterImage(greyScaleImage))
  }

  test("Filter: Scale Image With Invalid Scale Int") {
    val filter = new ScaleFilter(5)
    assertThrows[IllegalArgumentException](filter.filterImage(greyScaleImage))
  }

  test("Filter: Scale a Zero Dimensional Image") {
    // Mock the Image
    val image = mock[GreyScaleImage]
    when(image.getHeight).thenReturn(0)
    when(image.getWidth).thenReturn(0)

    val filter = new ScaleFilter(4)
    val scaledImage = filter.filterImage(image)
    assert(scaledImage.getHeight == 0)
    assert(scaledImage.getWidth == 0)
    // Verify No Access to the Mock Image Get
    verify(image, times(0)).getPixel(any[Int], any[Int])
  }

  test("Filter: Rotate a 2x0 Dimensional Image") {
    // Mock the Image
    val image = mock[GreyScaleImage]
    when(image.getHeight).thenReturn(2)
    when(image.getWidth).thenReturn(0)

    val filter = new ScaleFilter(4)
    val scaledImage = filter.filterImage(image)
    assert(scaledImage.getHeight == 4)
    assert(scaledImage.getWidth == 0)
    // Verify No Access to the Mock Image Get
    verify(image, times(0)).getPixel(any[Int], any[Int])
  }

  test("Filter: Rotate a 0x2 Dimensional Image") {
    // Mock the Image
    val image = mock[GreyScaleImage]
    when(image.getHeight).thenReturn(0)
    when(image.getWidth).thenReturn(2)

    val filter = new ScaleFilter(4)
    val scaledImage = filter.filterImage(image)
    assert(scaledImage.getHeight == 0)
    assert(scaledImage.getWidth == 4)
    // Verify No Access to the Mock Image Get
    verify(image, times(0)).getPixel(any[Int],any[Int])
  }
}
