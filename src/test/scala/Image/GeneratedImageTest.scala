package Image

import org.scalatest.FunSuite
import scala.util.Random

class GeneratedImageTest extends FunSuite{
    def randomImage = new GeneratedImage()

  test("Height is non zero") {
    assert(randomImage.getHeight != 0)
  }

  test("Width is non zero") {
    assert(randomImage.getWidth != 0)
  }

  test("Image contains pixels") {
    // Get randomPixel from image
    val randPixel = (Random.between(0, randomImage.getHeight), Random.between(0, randomImage.getWidth))
    // Can be 0 --> need to fix this
    assert(randomImage.getPixel(randPixel._1, randPixel._2) != 0)
  }

}
