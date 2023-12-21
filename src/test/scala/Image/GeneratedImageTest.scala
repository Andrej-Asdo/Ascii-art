package Image

import Image.Pixel.RGBValue
import org.scalatest.FunSuite

class GeneratedImageTest extends FunSuite{


  test("[Generated Image] 3x3") {
    val arrayPixels = Array[Array[RGBValue]] (
      Array[RGBValue](
        RGBValue(1, 1, 1),
        RGBValue(1, 2, 3),
        RGBValue(1, 4, 6),
      ),
      Array[RGBValue](
        RGBValue(1, 1, 1),
        RGBValue(1, 2, 3),
        RGBValue(1, 4, 6),
      ),
      Array[RGBValue](
        RGBValue(1, 1, 1),
        RGBValue(1, 2, 3),
        RGBValue(1, 4, 6),
      ),

    )
    val randomImage: RGBImage = new GeneratedImage(3,3,arrayPixels)
    assert(randomImage.getHeight == 3)
    assert(randomImage.getWidth == 3)
    assert(randomImage.getPixel(0,0) == RGBValue(1,1,1))
    assert(randomImage.getPixel(1,2) == RGBValue(1,4,6))
    assertThrows[IndexOutOfBoundsException](randomImage.getPixel(5,5))
  }

  test("[Generated Image] 0x2") {
    val arrayPixels = Array[Array[RGBValue]]()
    val randomImage: RGBImage = new GeneratedImage(0, 2, arrayPixels)
    assert(randomImage.getHeight == 0)
    assert(randomImage.getWidth == 2)
    assertThrows[IndexOutOfBoundsException](randomImage.getPixel(0, 0))
    assertThrows[IndexOutOfBoundsException](randomImage.getPixel(1, 2))
    assertThrows[IndexOutOfBoundsException](randomImage.getPixel(5, 5))
  }
}
