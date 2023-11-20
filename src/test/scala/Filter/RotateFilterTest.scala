package Filter

import Image.GreyScaleImage
import Image.Pixel.GreyScaleValue
import org.scalatest.FunSuite

class RotateFilterTest extends FunSuite{

  val greyScaleImage: GreyScaleImage = new GreyScaleImage(3,3)
    .setPixel(GreyScaleValue(1),0,0)
    .setPixel(GreyScaleValue(2),0,1)
    .setPixel(GreyScaleValue(3),0,2)
    .setPixel(GreyScaleValue(4),1,0)
    .setPixel(GreyScaleValue(5),1,1)
    .setPixel(GreyScaleValue(6),1,2)
    .setPixel(GreyScaleValue(7),2,0)
    .setPixel(GreyScaleValue(8),2,1)
    .setPixel(GreyScaleValue(9),2,2)

  val rotatedBy90Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(4), 0, 1)
    .setPixel(GreyScaleValue(1), 0, 2)
    .setPixel(GreyScaleValue(8), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(7), 0, 0)
    .setPixel(GreyScaleValue(2), 1, 2)
    .setPixel(GreyScaleValue(9), 2, 0)
    .setPixel(GreyScaleValue(6), 2, 1)
    .setPixel(GreyScaleValue(3), 2, 2)

  val rotatedBy180Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(9), 0, 0)
    .setPixel(GreyScaleValue(8), 0, 1)
    .setPixel(GreyScaleValue(7), 0, 2)
    .setPixel(GreyScaleValue(6), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(4), 1, 2)
    .setPixel(GreyScaleValue(3), 2, 0)
    .setPixel(GreyScaleValue(2), 2, 1)
    .setPixel(GreyScaleValue(1), 2, 2)

  val rotatedBy270Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(6), 0, 1)
    .setPixel(GreyScaleValue(9), 0, 2)
    .setPixel(GreyScaleValue(2), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(3), 0, 0)
    .setPixel(GreyScaleValue(8), 1, 2)
    .setPixel(GreyScaleValue(1), 2, 0)
    .setPixel(GreyScaleValue(4), 2, 1)
    .setPixel(GreyScaleValue(7), 2, 2)

  val rotatedByMinus90Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(3), 0, 0)
    .setPixel(GreyScaleValue(6), 0, 1)
    .setPixel(GreyScaleValue(9), 0, 2)
    .setPixel(GreyScaleValue(2), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(8), 1, 2)
    .setPixel(GreyScaleValue(1), 2, 0)
    .setPixel(GreyScaleValue(4), 2, 1)
    .setPixel(GreyScaleValue(7), 2, 2)

  val rotatedByMinus180Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(9), 0, 0)
    .setPixel(GreyScaleValue(8), 0, 1)
    .setPixel(GreyScaleValue(7), 0, 2)
    .setPixel(GreyScaleValue(6), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(4), 1, 2)
    .setPixel(GreyScaleValue(3), 2, 0)
    .setPixel(GreyScaleValue(2), 2, 1)
    .setPixel(GreyScaleValue(1), 2, 2)

  val rotatedByMinus270Degrees: GreyScaleImage = new GreyScaleImage(3, 3)
    .setPixel(GreyScaleValue(7), 0, 0)
    .setPixel(GreyScaleValue(4), 0, 1)
    .setPixel(GreyScaleValue(1), 0, 2)
    .setPixel(GreyScaleValue(8), 1, 0)
    .setPixel(GreyScaleValue(5), 1, 1)
    .setPixel(GreyScaleValue(2), 1, 2)
    .setPixel(GreyScaleValue(9), 2, 0)
    .setPixel(GreyScaleValue(6), 2, 1)
    .setPixel(GreyScaleValue(3), 2, 2)

  val greyScaleImageDiffDim: GreyScaleImage = new GreyScaleImage(3,4)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 0, 2)
    .setPixel(GreyScaleValue(4), 0, 3)
    .setPixel(GreyScaleValue(5), 1, 0)
    .setPixel(GreyScaleValue(6), 1, 1)
    .setPixel(GreyScaleValue(7), 1, 2)
    .setPixel(GreyScaleValue(8), 1, 3)
    .setPixel(GreyScaleValue(9), 2, 0)
    .setPixel(GreyScaleValue(10), 2, 1)
    .setPixel(GreyScaleValue(11), 2, 2)
    .setPixel(GreyScaleValue(12), 2, 3)

  val rotatedBy90DiffDim: GreyScaleImage = new GreyScaleImage(4, 3)
    .setPixel(GreyScaleValue(9), 0, 0)
    .setPixel(GreyScaleValue(5), 0, 1)
    .setPixel(GreyScaleValue(1), 0, 2)
    .setPixel(GreyScaleValue(10), 1, 0)
    .setPixel(GreyScaleValue(6), 1, 1)
    .setPixel(GreyScaleValue(2), 1, 2)
    .setPixel(GreyScaleValue(11), 2, 0)
    .setPixel(GreyScaleValue(7), 2, 1)
    .setPixel(GreyScaleValue(3), 2, 2)
    .setPixel(GreyScaleValue(12), 3, 0)
    .setPixel(GreyScaleValue(8), 3, 1)
    .setPixel(GreyScaleValue(4), 3, 2)


  test("Filter: Rotate Image By 90 degrees") {
    val filter = new RotateFilter(90)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy90Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy90Degrees.getHeight)
    for(row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row,col) == rotatedBy90Degrees.getPixel(row,col))
    }
  }

  test("Filter: Rotate Image By 180 degrees") {
    val filter = new RotateFilter(180)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy180Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy180Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy180Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By 270 degrees") {
    val filter = new RotateFilter(270)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy270Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy270Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy270Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By 360 degrees") {
    val filter = new RotateFilter(360)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == greyScaleImage.getWidth)
    assert(rotated.getHeight == greyScaleImage.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == greyScaleImage.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By 540 degrees") {
    val filter = new RotateFilter(540)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy180Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy180Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy180Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By 4050 degrees") {
    val filter = new RotateFilter(4050)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy90Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy90Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy90Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By -90 degrees") {
    val filter = new RotateFilter(-90)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedByMinus90Degrees.getWidth)
    assert(rotated.getHeight == rotatedByMinus90Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedByMinus90Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By -180 degrees") {
    val filter = new RotateFilter(-180)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedByMinus180Degrees.getWidth)
    assert(rotated.getHeight == rotatedByMinus180Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedByMinus180Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By -270 degrees") {
    val filter = new RotateFilter(-270)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedByMinus270Degrees.getWidth)
    assert(rotated.getHeight == rotatedByMinus270Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedByMinus270Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By -360 degrees") {
    val filter = new RotateFilter(-360)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == greyScaleImage.getWidth)
    assert(rotated.getHeight == greyScaleImage.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == greyScaleImage.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image By -4050 degrees") {
    val filter = new RotateFilter(-4050)
    val rotated = filter.filterGreyScaleImage(greyScaleImage)
    assert(rotated.getWidth == rotatedByMinus90Degrees.getWidth)
    assert(rotated.getHeight == rotatedByMinus90Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedByMinus90Degrees.getPixel(row, col))
    }
  }

  test("Filter: Rotate Image with Different Dimensions") {
    val filter = new RotateFilter(90)
    val rotated = filter.filterGreyScaleImage(greyScaleImageDiffDim)
    assert(rotated.getWidth == rotatedBy90DiffDim.getWidth)
    assert(rotated.getHeight == rotatedBy90DiffDim.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy90DiffDim.getPixel(row, col))
    }
  }
}
