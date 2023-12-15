package Filter

import Image.GreyScaleImage
import Image.Pixel.GreyScaleValue
import org.scalatest.FunSuite

class MixedFilterTest extends FunSuite{
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

  val greyScale2x2Image: GreyScaleImage = new GreyScaleImage(2, 2)
    .setPixel(GreyScaleValue(1), 0, 0)
    .setPixel(GreyScaleValue(2), 0, 1)
    .setPixel(GreyScaleValue(3), 1, 0)
    .setPixel(GreyScaleValue(4), 1, 1)

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

  val rotatedInvertedScaled: GreyScaleImage = new GreyScaleImage(4, 4)
    .setPixel(GreyScaleValue(252), 0, 0)
    .setPixel(GreyScaleValue(252), 0, 1)
    .setPixel(GreyScaleValue(254), 0, 2)
    .setPixel(GreyScaleValue(254), 0, 3)
    .setPixel(GreyScaleValue(252), 1, 0)
    .setPixel(GreyScaleValue(252), 1, 1)
    .setPixel(GreyScaleValue(254), 1, 2)
    .setPixel(GreyScaleValue(254), 1, 3)
    .setPixel(GreyScaleValue(251), 2, 0)
    .setPixel(GreyScaleValue(251), 2, 1)
    .setPixel(GreyScaleValue(253), 2, 2)
    .setPixel(GreyScaleValue(253), 2, 3)
    .setPixel(GreyScaleValue(251), 3, 0)
    .setPixel(GreyScaleValue(251), 3, 1)
    .setPixel(GreyScaleValue(253), 3, 2)
    .setPixel(GreyScaleValue(253), 3, 3)

  test("Filter: Mixed Filter with one Filter") {
    val filter = new MixedFilter(List[GreyScaleFilter] {new RotateFilter(90)})
    val rotated = filter.filterImage(greyScaleImage)
    assert(rotated.getWidth == rotatedBy90Degrees.getWidth)
    assert(rotated.getHeight == rotatedBy90Degrees.getHeight)
    for (row <- 0 until rotated.getHeight; col <- 0 until rotated.getWidth) {
      assert(rotated.getPixel(row, col) == rotatedBy90Degrees.getPixel(row, col))
    }
  }

  test("Filter: Mixed Filter with all Filters") {
    val filter = new MixedFilter(List[GreyScaleFilter] (new RotateFilter(90), new InvertFilter(), new ScaleFilter(4)))
    val filtered = filter.filterImage(greyScale2x2Image)
    assert(filtered.getWidth == rotatedInvertedScaled.getWidth)
    assert(filtered.getHeight == rotatedInvertedScaled.getHeight)
    for (row <- 0 until filtered.getHeight; col <- 0 until filtered.getWidth) {
      assert(filtered.getPixel(row, col) == rotatedInvertedScaled.getPixel(row, col))
    }
  }

  test("Filter: Mixed Filter with No Filter") {
    val filter = new MixedFilter(List[GreyScaleFilter]())
    val filtered = filter.filterImage(greyScaleImage)
    assert(filtered.getWidth == greyScaleImage.getWidth)
    assert(filtered.getHeight == greyScaleImage.getHeight)
    for (row <- 0 until filtered.getHeight; col <- 0 until filtered.getWidth) {
      assert(filtered.getPixel(row, col) == greyScaleImage.getPixel(row, col))
    }
  }

  test("Filter: Mixed Filter with Invalid Arguments in One Filter") {
    val filter = new MixedFilter(List[GreyScaleFilter] (new RotateFilter(95), new InvertFilter(), new ScaleFilter(4)))
    assertThrows[IllegalArgumentException](filter.filterImage(greyScaleImage))
  }

  test("Filter: Mixed Filter with Invalid Arguments in More Filters") {
    val filter = new MixedFilter(List[GreyScaleFilter](new RotateFilter(95), new InvertFilter(), new ScaleFilter(4.5)))
    assertThrows[IllegalArgumentException](filter.filterImage(greyScaleImage))
  }
}
